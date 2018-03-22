package day01

class Test1 {

}

object Test1 {
  def main(args:Array[String]): Unit = {
    println("Hello world")
    val x = 3

    // 基本数据类型
    val a:Byte = 1
    val b:Char = '1'
    val c:Short = 11
    val d:Int = 111
    val e:Long = 1111
    val f:Float = 1.11F
    val g:Double = 1.11D

    // 条件表达式
    val y = if (x > 1) 1 else -1

    // 混合类型
    val z = if (x < 1) 1 else "error"
    for (i <- 1 until 10) {
      println(i)
    }

    println("---------------------")
    val arr = Array(1, 2, "123")
    for (i <- arr) {
      println(i)
    }

    // for循环
    println("---------------------")
    for (i <- 1 to 3; j <- 1 to 3 if (i!=j)) {
      println(i + j)
    }

    //yield生成vector
    val res = for (i <- 1 until 10) yield i

    println(res)
    println(1. + (2))

    // 方法
    def m1(x:Int, y:Int):Int = x+y

    // 函数
    val f1 = (x:Int, y:Int) => x+y

    // 函数可以作为方法的参数
    def m2(f: (Int, Int) => Int) = f(1, 2)

    println(m2(f1))

    // 方法转换为函数
    val f2 = m1 _
    println(m2(f2))

    // 隐式转换
    println(m2(m1))

  }
}
