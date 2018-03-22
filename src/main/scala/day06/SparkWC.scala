package day06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object SparkWC {
  def main(args: Array[String]): Unit = {
    // 配置信息类
    val conf:SparkConf = new SparkConf().setAppName("WC").setMaster("local[*]")

    // 上下文对象
    val sc:SparkContext = new SparkContext(conf)

    // 读取数据
    val lines = sc.textFile(args(0))

    // 处理数据
    val words:RDD[String] = lines.flatMap(_.split(" "))
    val paired:RDD[(String, Int)] = words.map((_, 1))
    val reduced:RDD[(String, Int)] = paired.reduceByKey(_ + _)
    val res:RDD[(String, Int)] = reduced.sortBy(_._2, false)

    println(res.collect().toBuffer)
    //    res.saveAsTextFile(args[1])

    // 结束任务

    sc.stop()


  }

}
