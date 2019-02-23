package inheritance

class Polygon {
  def area: Double = 0.0
}

object Polygon {
  def main(args: Array[String]): Unit = {
    var poly = new Polygon;
    printArea(poly)
    var rect = new Rectangle(12, 11)
    printArea(rect)
    var tri = new Triangle
    printArea( tri)
  }

  def printArea(p: Polygon): Unit = {
    println(p.area)
  }
}
