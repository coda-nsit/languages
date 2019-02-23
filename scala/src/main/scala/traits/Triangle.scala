package traits

class Triangle(var base: Double, var height: Double) extends Polygon  with Shape {
  override def area:  Double = 0.5 * base * height
  override def color: String = "yellow"
}
