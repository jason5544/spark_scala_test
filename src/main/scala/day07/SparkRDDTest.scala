package day07

import org.apache.spark.{SparkConf, SparkContext}

object SparkRDDTest {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkRDDTest").setMaster("local")
    val sc = new SparkContext(conf)

    // 并行化生成rdd
    val rdd1 = sc.parallelize(List(5, 6, 4, 2, 3, 1, 3 ,4,1, 2, 1 ))

    // 将元素以数组的方式打印出来
    // 对rdd1里面的每一个元素*2，并排序
    val res1 = rdd1.map(_*2).sortBy(x=>x, true)

    // 过滤大于等于10的元素
    val res2 = res1.filter(_ >= 10)

    println(res2.collect().toBuffer)

    val rdd2 = sc.parallelize(Array("a b c d", "d e f", "g h"))

    // 将rdd2中的每一个元素先切分再压平
    val res3 = rdd2.flatMap(_.split(" "))
    println(res3.collect.toBuffer)


    // 先切分，再压平
    val rdd3 = sc.parallelize(List(List("a b c", "a b b"), List("e f g", "a f g"), List("h i j", "a a b")))
    val res4 = rdd3.flatMap(_.flatMap(_.split(" ")))
    println(res4.collect().toBuffer)


    val rdd4 = sc.parallelize(List(5, 6, 4, 3))
    val rdd5 = sc.parallelize(List(1, 2, 3, 4))

    //  求并集
    println(rdd4.union(rdd5).collect.toBuffer)

    // 交集
    println(rdd4.intersection(rdd5).collect().toBuffer)

    // 去重
    println(rdd4.intersection(rdd5).distinct().collect().toBuffer)


    val rdd6 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd7 = sc.parallelize(List(("jerry", 2),("tom", 1), ("shuke", 2)))

    // join
    println(rdd6.join(rdd7).collect().toBuffer)
    // 左连接
    println(rdd6.leftOuterJoin(rdd7).collect().toBuffer)
    // 右连接
    println(rdd6.leftOuterJoin(rdd7).collect().toBuffer)

    // 求并集
    val res = rdd6.union(rdd7)
    println(res.collect().toBuffer)

    // 按照key进行分组
    // groupByKey
    println("group by key")
    println(res.groupByKey().mapValues(_.sum).collect().toBuffer)
    println("reduce by key")
    println(res.reduceByKey(_ + _).collect().toBuffer)

    // cogroup
    val rdd8 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 2)))
    val rdd9 = sc.parallelize(List(("tom", 2), ("jerry", 3)))

    println(rdd8.cogroup(rdd9).collect().toBuffer)

    // 降序
    val res11 = rdd8.reduceByKey(_+_).map(t=>(t._2, t._1)).sortByKey(false).map(t => (t._2, t._1))
    println(res11.collect().toBuffer)

    // 笛卡尔积
    println(rdd8.cartesian(rdd9).collect().toBuffer)

    // count, top, take, first, takeOrdered

  }

}
