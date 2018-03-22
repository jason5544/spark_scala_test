package day01

import scala.collection.mutable._

class TestHashMap {

}

object TestHashMap {
  def main(args: Array[String]): Unit = {
    val map1 = new HashMap[String, Int]()

    map1("scala") = 1

    map1 += (("java", 2))

    map1.put("c++", 5)
    map1 -= ("c++")
    map1.remove("c++")
  }
}
