package day09

import org.apache.spark.{SparkConf, SparkContext}

object MySort {
  implicit val girlOrdering = new Ordering[Girl] {
    override def compare(x: Girl, y: Girl) = {
      if (x.faceValue != y.faceValue) {
        x.faceValue - y.faceValue
      } else {
          x.age - y.age
      }
    }
  }
}

object CustomSort {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CustomSort").setMaster("local[*]")
    val sc = new SparkContext(conf)


    import MySort.girlOrdering
    val girlInfo = sc.parallelize(Array(("tingting", 80, 25), ("ningning", 90, 26), ("mimi", 90, 27)))

    val res = girlInfo.sortBy(x => Girl(x._2, x._3), false)
    println(res.collect().toBuffer)
  }
}

case class Girl(faceValue: Int, age: Int) { }

//case class Girl(faceValue: Int, age: Int) extends Ordered[Girl] {
//  override def compare(that: Girl): Int = {
//    if (this.faceValue != that.faceValue) {
//      this.faceValue - that.faceValue
//    } else {
//      that.age - this.age
//    }
//  }
//}
