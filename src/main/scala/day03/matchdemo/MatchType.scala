package day03.matchdemo

import scala.util.Random

/**
  * 模式匹配
  *
  */

object MatchType {
  def main(args:Array[String]): Unit = {
    val arr = Array("abcde", "zhoudongyv")

    val name = arr(Random.nextInt(arr.length))

    println(name)

    name match {
      case "zhoudongyv" => println("周东雨")
      case _ => println("Nothing")
    }



  }
}
