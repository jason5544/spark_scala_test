package day03.matchdemo

/**
  * PartialFunction[A, B], 其中A是参数类型，B是返回值类型, PartialFunction 偏函数 常用作输入模式匹配
  */
object PartialFunctionDemo {

  def m1: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
  }

  def m2(num:String): Int = num match {
    case "one" => 1
    case "two" => 2
  }

}
