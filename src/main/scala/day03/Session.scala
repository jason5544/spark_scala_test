package day03

/**
  * 在scala中没有静态方法和静态字段，但可以使用object关键字加类名的语法结构实现同样的功能
  * 1. 工具类，存放常量的工具方法
  * 2. 实现单例模式
  */

object SingletonDemo {
  def main(args: Array[String]): Unit = {

    val factory = SessionFactory

    val sess = factory.getSession

  }
}

object SessionFactory {
  println("SessionFactory")

  private val session = new Session()

  def getSession = session

}

class Session {


}
