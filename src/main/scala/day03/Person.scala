package day03

class Person {

  // 用val修饰的变量只读,相当于只要get,没有set
  val id: String = "100"

  // var修饰的变量相当于即有get又有set方法
  var name: String = _

  // 用private修饰的的变量，属于私有,只能在本类和其伴生对象中访问
  private var age: Int = _

  // 只能在本类中访问
  private[this] val gender = "男"

}

object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person()

    println(p.id)

//    p.id = 100
    p.name = "Jason"
    println(p.name)
    println(p.age)
  }
}
