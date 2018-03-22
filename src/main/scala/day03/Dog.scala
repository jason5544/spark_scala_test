package day03

/**
  * 与类名相同，并且用object修饰的对象
  * 类和伴生对象之间可以相互访问私有方法和属性
  */

class Dog {
  private var name = "二哈"

  def printName(): Unit = {
    println(Dog.CONSTANT + name)
  }
}

object Dog {
  private val CONSTANT = "汪汪汪"

  def main(args: Array[String]): Unit = {
    val p = new Dog

    println(p.printName())
  }
}
