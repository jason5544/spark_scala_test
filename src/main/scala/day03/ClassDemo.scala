package day03

object ClassDemo {
  def main(args: Array[String]): Unit = {

    val human = new Human

    println(human.name)
    println(human.climb)
    println(human.fight)

  }
}

/**
  * 特质
  * 可以继承多个特质
  */
trait Flyable {
  // 声明一个没有值的字段
  val distance:Int

  // 声明一个有值的字段
  def hight = 100

  // 声明一个没有实现的方法
  def fight: String

  // 声明一个有实现的方法
  def fly: Unit = {
    println("I can fly")
  }

}

/**
  * 声明一个抽象类, 也trait差不多
  */

abstract class Animal {
  // 声明一个没有赋值的字段
  val name: String

  // 声明一个没有实现的方法
  def run(): String

  // 声明一个有实现的方法
  def climb: String = {
    "I can climb"
  }
}

class Human extends Animal with Flyable {
  override val name: String = "jason"

  // 实现抽象类中没有实现的方法
  override def run(): String = {
    println("run")
    "run"
  }

  // 实现抽象类中有实现的方法
  override def climb: String = "climb"

  override val distance: Int = 1

  // 实现特质中没有实现的方法
  override def fight: String = {
    println("fight")
    "fly"
  }

  // 实现特质中有实现的方法
  override def fly: Unit = "fly"
}
