package lab2

class Int2DVec private (val x: Int, val y: Int) {
  def +(other: Int2DVec) = new Int2DVec(x + other.x, y + other.y)
  def unary_- = new Int2DVec(-x, -y)
  def unary_+ = new Int2DVec(x+1, y+1)
  def -(other: Int2DVec): Int2DVec = new Int2DVec(x - other.x, y - other.y)
  override def toString = s"Int2DVec($x, $y)"
}

object Int2DVec {
  val default = new Int2DVec(0, 0)
  def apply(x: Int, y: Int): Int2DVec = new Int2DVec(x, y)
  def apply(other: Int2DVec): Int2DVec = new Int2DVec(other.x, other.y)
  def apply(): Int2DVec = default
}

object App {
  def main(args: Array[String]) {
    val v1 = Int2DVec(1, 2)
    val v2 = Int2DVec(10, 20)
    val v3 = v1 + v2
    val v4 = -v2
    val v5 = +v2
    val v6 = v2 - v1
    println(v3)
    println(v4)
    println(v5)
    println(v6)

    println(Int2DVec())
    println(Int2DVec(v1 + v1 + v2))
  }
}
