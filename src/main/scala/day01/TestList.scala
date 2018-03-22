package day01


import collection.mutable.ListBuffer

object TestList {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = 0::list1
    val list3 = list1.::(0)
    val list4 = 0 +: list1
    val list5 = list1.+:(0)

    val list6 = list1 :+ 4

    val list7 = List(3, 4, 5)
    val list8 = list1 ++ list7
    val list9 = list1 ++: list7
//    val list10 = list1 +++ list9

    val l1 = ListBuffer(1, 2, 3)
    l1 += 4
    l1.append(5)
    val l2 = ListBuffer(3,4,5)



  }

}
