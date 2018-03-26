package day03.matchdemo

import scala.util.Random

/**
  * 模式匹配
  *
  */

object MatchStr {
  def main(args:Array[String]): Unit = {
    val arr = Array("zhoudongyv", "abcde")

    val name = arr(Random.nextInt(arr.length))

    println(name)

    name match {
      case "abcde" => println("abcde")
      case _ => println("Nothing")
    }



  }
}
