package day02

class ListExcercese3 {

}


object ListExcercese3 {
  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3, 4, 5)
    val l2 = List(1, 2, 7, 8, 0)

    // 并，交，差
    println(l1 union l2)

    println(l1 intersect l2)

    println(l1 diff l2)
  }

}