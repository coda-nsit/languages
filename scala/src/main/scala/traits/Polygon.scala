// interface: is used to implement multiple inheritance
// methods or properties that an implementing class should have
// traits: partially implemented interfaces
// at least one method should me abstract
package traits

trait Shape {
  def color: String
}

abstract class Polygon {
  def area: Double
}

object Polygon{
  def main(args: Array[String]): Unit = {
    var rect = new Rectangle(12, 11)
    printArea(rect)
    println(rect.color)
    var tri = new Triangle(29, 4)
    printArea( tri)
    println(tri.color)

  }

  def printArea(p: Polygon): Unit = {
    println(p.area)
  }
}