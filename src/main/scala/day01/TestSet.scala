package day01

import scala.collection.mutable.HashSet

class TestSet {
  def main(args: Array[String]): Unit = {
    val set1 = Set(1)

    val set2 = HashSet(1)
    set2.add(1)

    set2 ++= set1

    set2.remove(2)
  }

}
