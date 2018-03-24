package day08

import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

/**
  * 缓存机制
  * 自定义一个分区器
  * 按照每个学科
  */
object ObjectCount2 {
  def main(args: Array[String]): Unit = {
    val conf:SparkConf = new SparkConf().setAppName("ObjectCount2").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)

    val lines = sc.textFile("learn.log")

    val addOne: RDD[(String, Int)] = lines.map(x =>{
      val url = x.split("\t")(1)
      (url, 1)
    })

    val sumedURL: RDD[(String, Int)] = addOne.reduceByKey(_+_)

    // 获取学科信息
    val cachedProject: RDD[(String, (String, Int))] = sumedURL.map(x => {
      val url = x._1
      val project = new URL(url).getHost
      val count = x._2
      (project, (url, count))
    }).cache()

    // 得到所有学科
    val projects: Array[String] = cachedProject.keys.distinct().collect()

    // 调用自定义分区器得到分区号
    val partitioner: ProjectPartitioner = new ProjectPartitioner(projects)

    val partitioned: RDD[(String, (String, Int))] = cachedProject.partitionBy(partitioner)

    // 对分区后的数据，取每个学科的top3
    val res: RDD[(String, (String, Int))] = partitioned.mapPartitions(it => {
      it.toList.sortBy(_._2._2).reverse.take(3).iterator
    })

    res.saveAsTextFile("result")

    sc.stop()

  }
}

class ProjectPartitioner(projects: Array[String]) extends Partitioner {
  private val projectAndPartNum = new mutable.HashMap[String, Int]
  var n = 0

  for (pro <- projects) {
    projectAndPartNum += (pro -> n)
    n += 1
  }

  override def numPartitions: Int = projects.length

  override def getPartition(key: Any): Int = {
    projectAndPartNum.getOrElse(key.toString, 0)
  }
}
