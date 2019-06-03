object AppHOF {
  def df(f: Double => Double) = {
    x: Double => {
      val h = 1e-3
      (f(x + h) - f(x)) / h
    }
  }

  def d2f(f: Double => Double) = df(df(f))

  def main(args: Array[String]): Unit = {
    val sqr = (x: Double) => x * x
    val f = d2f(sqr)
    println(f(2.0))
    println(f(.0))
  }
}
