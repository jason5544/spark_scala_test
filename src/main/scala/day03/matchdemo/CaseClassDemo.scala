package day03.matchdemo

import scala.util.Random

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(CheckTimeOutTask, SubmitTask("100", "task-0001"), HeartBeat(100))

    val a = arr(Random.nextInt(arr.length)) match {
      case CheckTimeOutTask => 1
      case SubmitTask(port, task) => 2
      case HeartBeat(time) => 3
    }

    println(a)

  }
}

// 样例
// 初始化
// 多例
case class HeartBeat(time: Long)
case class SubmitTask(id: String, taskName: String)
// 单例
case object CheckTimeOutTask
