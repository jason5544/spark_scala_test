package day02

class ListExcercise1 {

}

object ListExcercise1 {

  def main(args: Array[String]): Unit = {
    // 并行计算求和
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4)
    val res = arr.par.sum

    // 按照特定顺序聚合

    val res1 = arr.reduce(_+_)
    val res2 = arr.par.reduce(_-_)

    // 折叠,每个线加初始值
    val res3 = arr.par.fold(10)(_+_)

    println(res3)

  }


}
