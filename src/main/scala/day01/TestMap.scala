package day01

import scala.collection.mutable._

object TestMap {
  def main(args:Array[String]):Unit = {
    val map1 = Map("scala"->1, "java"->2)
    val map2 = Map(("scala", 1), ("Java", 2))
    map1("scala") = 2
    map1.getOrElse("C#",-1)
  }

}
