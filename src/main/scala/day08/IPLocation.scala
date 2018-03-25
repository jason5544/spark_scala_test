package day08

import java.sql.{Connection, Date, DriverManager, PreparedStatement}

import org.apache.spark.{SparkConf, SparkContext}

object IPLocation {

  val dataMySQL = (iterator: Iterator[(String, Int)]) => {
    var conn: Connection = null
    var ps: PreparedStatement = null
    val sql = "insert into location_info (location, counts, access_date) values (?,?,?)"
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8",
        "root", "123456")
      iterator.foreach(line => {
        ps = conn.prepareStatement(sql)
        ps.setString(1, line._1)
        println(line._1)
        ps.setInt(2, line._2)
        ps.setDate(3, new Date(System.currentTimeMillis()))
        ps.executeUpdate()
      })
    } catch {
      case e: Exception => {println("Mysql Exception"); e.printStackTrace()}
    } finally {
      if (ps != null) {
        ps.close()
      }
      if (conn != null) {
        conn.close()
      }
    }
  }

  def ip2Long(ip:String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length) {
      ipNum = fragments(i).toLong | ipNum << 8L
    }
     ipNum
  }

  def binarySearch(lines: Array[(String, String, String)], ip: Long): Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high)/2

      if ((ip >= lines(middle)._1.toLong) && (ip <= lines(middle)._2.toLong)) {
        return middle
      }

      if (ip < lines(middle)._1.toLong) {
        high = middle - 1
      } else {
        low = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("IPLocation").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)

    val ipRulesRdd = sc.textFile("ip/ip.txt").map(line => {
      val fileds = line.split("\\|")
      val startIP = fileds(2)
      val endIP = fileds(3)
      val province = fileds(6)
      (startIP, endIP, province)
    })

    val ipRuleArray = ipRulesRdd.collect()
    val ipRulesBroadcast = sc.broadcast(ipRuleArray)

    val ipsRDD = sc.textFile("ip/access_log").map(line => {
      val fields = line.split("\\|")
      val ip = fields(1)
      val ipTOLong = ip2Long(ip)
      val arr = ipRulesBroadcast.value
      val index = binarySearch(arr, ipTOLong)
      val province = arr(index)._3
      (province, 1)
    })

    val res = ipsRDD.reduceByKey(_+_)
    res.foreachPartition(dataMySQL(_))
    sc.stop()
  }
}
