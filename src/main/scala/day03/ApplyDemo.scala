package day03

/**
  * apply方法通常称为注入方法，在伴生对象中做一些初始化操作
  * apply方法参数列表不需要和构造器参数列表统一
  * unapply方法通常称为提取方法，使用unapply方法提取固定数量的对象
  * unapply方法会返回一个序列(Option),内部产生一个Some对象来存放一些值
  * apply方法和unapply方法会被隐式的调用
  * @param name
  * @param age
  * @param faceValue
  */
class ApplyDemo(val name:String, var age: Int, var faceValue: Int) {

}

object ApplyDemo {
  def apply(name: String, age: Int, faceValue:Int): ApplyDemo = {
    new ApplyDemo(name, age, faceValue)
  }

  def unapply(arg: ApplyDemo): Option[(String, Int, Int)] = {
    if (arg == null) {
      None
    } else {
      Some(arg.name, arg.age, arg.faceValue)
    }
  }
}
