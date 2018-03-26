package day03.matchdemo

class MatchList {

}

/**
  * 匹配数组
  */
object MatchList {
  def main(args: Array[String]): Unit = {
    // 匹配数组
    val arr = Array(4, 2, 5, 7)

    arr match {
      case Array(4, a, b, c) => println(s"case , $a, $b, $c")
      case Array(_, x, y) => println(s"case $x, $y")
      case _ => println("Not Matched")
    }

    // 匹配元祖

    val tup = (2, 3, 4)
    tup match {
      case (2, a, b) => println(s"$a, $b")
      case (_, x, y) => println(s"$x, $y")
      case _ => println("Not Matched")
    }

    // 匹配集合
    val list1 = List(0, 1, 2, 3)

    list1 match {
      case 0 :: Nil => println("case:0")
      case a :: b :: c :: d :: Nil => println("a b c d")
      case _ => println("_")
    }

  }
}
