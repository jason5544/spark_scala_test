package day02

class LazyDemo {

}

/**
  * scala中用lazy定义惰性变量,会实现延迟加载
  *
  */
object LazyDemo {
  def init():Unit = {
    println("init")
  }

  def main(args:Array[String]):Unit = {
    val f = init()
    println("main")
    println(f)
  }
}

object LazyDemo2 {
  def init():Unit = {
    println("init")
  }

  def main(args:Array[String]):Unit = {
    lazy val f = init()
    println("main")
    println(f)
  }
}
