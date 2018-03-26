package day03.matchdemo

import scala.util.Random


class MatchType {

}

/**
  * 类型匹配
  */

object MatchType {
  def main(args: Array[String]): Unit = {
    val arr = Array("abced", 100, 3.14, true, MatchType)

    val element = arr(Random.nextInt(arr.length))

    println(element)

    element match {
      case str: String => println(s"match String: $str")
      case int: Int => println(s"match int: $int")
      case bool: Boolean => println(s"match Boolean: $bool")
      case matchType: MatchType => println(s"match MatchType: $matchType")
      case _: Any => println("Not match")
    }
  }
}
