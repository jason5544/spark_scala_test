package day03

/**
  * 主构造器的参数列表要放到类名后面，和类名放在一起
  * val修造的构造参数具有不可变性，var有可变性
  * 此时声明的faceValue只能在本类调用，伴生对象也无法调用
 *
  * @param name
  * @param age
  * @param faceValue
  */

// 主构造器
class StructDemo(val name: String, var age: Int, faceValue: Int = 90) {

  def getFaceValue(): Int = {
//    faceValue = 100 //默认的为val
    faceValue
  }
  var gender: String = _
  // 辅助构造器
  def this(name:String, age: Int, faceValue: Int, gender:String) {
    this(name, age, faceValue)
    this.gender = gender
  }
}

object StructDemo {
  def main(args: Array[String]): Unit = {
    val s = new StructDemo("ningning", 26, 98)

    s.age = 100
//    s.name = "Tom"
    println(s.name)
    println(s.age)
  }
}
