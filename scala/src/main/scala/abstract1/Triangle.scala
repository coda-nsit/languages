package abstract1

class Triangle(val base: Int, val height: Int) extends Abstract1Polygon {
  def area: Double = base * height * 0.5
}
