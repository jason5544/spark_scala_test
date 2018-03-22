package day01

import scala.collection.mutable.ArrayBuffer

object TestArray {
  def main(args:Array[String]):Unit = {
    // 固定数组
   val arr1 = new Array[Int](8)
    arr1(1) = 5

    // 转换成数组缓存,打印
    println(arr1.toBuffer)



    // 调用静态类
    val arr2 = Array(1, 2, 3)
    println(arr2.toBuffer)

    //变长数组
    val arr3 = ArrayBuffer[Int]()
    arr3 += 1
   // 加入元组
    arr3 += (1, 2, 3, 4)
   // 加入定长数组
    arr3 ++= Array(1, 2)
   // 加入变成数组
    arr3 ++= ArrayBuffer(3, 4)
   // 在下标为0位置插入 -1，0
    arr3.insert(0, -1 , 0)
    arr3 ++= arr1
   println(arr3)

   // for循环打印
   for (i <- arr1) {
    println(i)
   }

   for (i <- 0 until arr1.length) {
    println(arr1(i))
   }

  println(arr1.min)
   println(arr1.max)
   println("-----------------sorted--------------")
   arr1.sorted

   println(arr1.toBuffer)


  }

}
