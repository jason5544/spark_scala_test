package day02

class ListExcercise {

}

object ListExcercise {
  def main(args: Array[String]): Unit = {
    // 创建list
    val list0 = List(1, 2, 3, 3, 2, 3, 6, 3, 5)

    // list每个原素*2
    val list1 = list0.map(_ * 2)

    val list2 = list0.filter(_ % 2 == 0)

    // 如果方法没有参数，不用输入小括号
    val list3 = list0.sorted
    val list4 = list0.reverse


    // 分组得到 Iterator对象
    val it = list0.grouped(4)
    val list5 = it.toList

    // 压扁成一个list
    val list6 = list5.flatten

    val lines = List("Hello java hello scala", "hello scala", "hello jason")

//    val words = lines.map(_.split(" "))

//    val flatwords= words.flatten

    val flatwords = lines.flatMap(_.split(" "))

    println(flatwords)



  }
}
