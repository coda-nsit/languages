package inheritance

class Rectangle(var width: Double, var height: Double) extends Polygon {
  // override keyword required if child modifies the functions of parent
  override def area: Double = width * height
}
