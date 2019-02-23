package abstract1

class Rectangle(var width: Double, var height: Double) extends Abstract1Polygon{
  // override keyword required if child modifies the functions of parent
  def area: Double = width * height
}
