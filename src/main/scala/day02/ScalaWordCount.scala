package day02

class ScalaWordCount {

}

object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("hello java hello pyhon", "hello jason", "hello tom")
    val words = lines.flatMap(_.split(" "))
    val tuples = words.map((_, 1))

    val grouped = tuples.groupBy(_._1)

    // 统计 value的长度

    val sumed = grouped.mapValues(_.size)

    val res = sumed.toList.sortBy(_._2)


    val res1 = res.reverse

    println(res1)
  }
}
