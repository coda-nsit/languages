package abstract1

// abstract classes
// 1. cant be instantiated
// 2. can have abstract methods (no definition) and normal methods

abstract class Abstract1Polygon {
  def area: Double
}

object Abstract1Polygon{
  def main(args: Array[String]): Unit = {
    var rect = new Rectangle(12, 11)
    printArea(rect)
    var tri = new Triangle(29, 4)
    printArea( tri)
  }

  def printArea(p: Abstract1Polygon): Unit = {
    println(p.area)
  }
}
