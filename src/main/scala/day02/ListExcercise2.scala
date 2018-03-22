package day02

object ListExcercise2 {
  def main(args: Array[String]): Unit = {
    val list1 = List(List(1, 2, 3), List(2, 3, 4), List(5, 3, 2))

//    val res = list1.flatten.reduce(_+_)

    val res = list1.aggregate(0)(_+_.sum, _+_)

    println(res)

  }

}
