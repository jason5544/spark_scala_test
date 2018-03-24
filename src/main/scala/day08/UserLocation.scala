package day08

import org.apache.spark.{SparkConf, SparkContext}

object UserLocation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("UserLocation").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // bs_log输入：手机号，时间戳，基站,离开\进入
    // 18611132889,20160327181500,CC0710CC94ECC657A8561DE549D940E0,0
    val rdd_Info = sc.textFile("bs_log").map(line => {
      val fields = line.split(",")
      val eventType = fields(3)
      val time = fields(1)
      val timeLong = if(eventType == "1") -time.toLong else time.toLong
      ((fields(0), fields(2)), timeLong)
    })

    val rdd_lacInfo = rdd_Info.reduceByKey(_+_).map(t=>{
      val mobile = t._1._1
      val lac = t._1._2
      val time = t._2
      (lac, (mobile, time))
    })

    val rdd_coordinate = sc.textFile("lac_info.txt").map(line => {
      val f = line.split(",")
      (f(0),(f(1), f(2)))
    })

    val rdd_all = rdd_lacInfo.join(rdd_coordinate).map(t=>{
      val lac = t._1
      val mobile = t._2._1._1
      val time = t._2._1._2
      val x= t._2._2._1
      val y = t._2._2._2
      (mobile, lac, time, x, y)
    })

    val rdd_mobile = rdd_all.groupBy(_._1)
    val rdd_topTwo = rdd_mobile.mapValues(it=> {
      it.toList.sortBy(_._3).reverse.take(2)
    })

    rdd_topTwo.saveAsTextFile("out")
    sc.stop()

  }

}
