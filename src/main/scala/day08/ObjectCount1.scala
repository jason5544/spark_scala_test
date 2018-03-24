package day08

import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 统计各用户对每个学科各个模块访问次数的top3
  */
object ObjectCount1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("ObjectCount1").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)

    val file: RDD[String] = sc.textFile("learn.log")

    val urlAddOne: RDD[(String, Int)] = file.map(line => {
      val fileds = line.split("\t")
      val url = fileds(1)
      (url, 1)
    })

    // 相同url聚合
    val sumedUrl: RDD[(String, Int)] = urlAddOne.reduceByKey(_+_)

    // 获取学科信息
    val project: RDD[(String, String, Int)] = sumedUrl.map(x => {
      val url = x._1
      val count = x._2
      val project = new URL(url).getHost
      (project, url, count)
    })

//    println(project.collect().toBuffer)
    val res: RDD[(String, List[(String, String, Int)])] =
      project.groupBy(_._1).mapValues(_.toList.sortBy(_._3).reverse.take(3))
    println(res.collect().toBuffer)

    res.saveAsTextFile("result1")

    sc.stop()
  }

}
