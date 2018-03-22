package day01

class TestTuple {

}

object TestTuple {
  def main(args:Array[String]): Unit = {
    val t, (a, b, c, d) = ("Scala", 100L, 3.14, ("Spark", 1))

    println(t._1)
    println(t._4._1)
    println(a)

    // 数组转为为map

    val arr = Array(("tingting", 24), ("Mingming", 22))

    val arr1 = arr.toMap

    println(arr1("tingting"))

    // 拉链操作

    val a1 = Array("a", "b", "c")
    val a2 = Array(1, 2, 3)

    a1.zip(a2)
  }
}
