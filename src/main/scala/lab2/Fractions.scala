package lab2

trait Fraction {
  val num: Int
  val denom: Int
  def *(other: Fraction): Fraction = Fraction(num * other.num, denom * other.denom)
}

trait Loggable {
  def log(timeStamp: Long, msg: String): Unit = println("[" + timeStamp.toString + "]: " + msg)
}

trait Simplifiable {
  def simplify(fraction: Fraction): Fraction = {
    val gcd = BigInt(fraction.num).gcd(fraction.denom)
    Fraction((fraction.num / gcd).toInt, (fraction.denom / gcd).toInt)
  }
}

object Fraction {
  // one of the "creational patterns/idioms"
  def apply(num: Int, denom: Int, loggable: Boolean = false): Fraction =
    if (loggable) new LoggableImpl(num, denom) else new DefaultImpl(num, denom)

  private class DefaultImpl(val num: Int, val denom: Int) extends Fraction with Simplifiable {
    override def *(other: Fraction): Fraction =
      simplify(Fraction(this.num * other.num, this.denom * other.denom))
    override def toString: String = num.toString + "/" + denom.toString
  }

  private class LoggableImpl(num: Int, denom: Int) extends DefaultImpl(num, denom) with Loggable {
    def timeStamp: Long = System.nanoTime // to keep the example short...
    override def *(other: Fraction): Fraction = {
      log(timeStamp, "multiplying " + this.toString + " by " + other.toString)
      Fraction(this.num * other.num, this.denom * other.denom, loggable = true) // super.*(other) is not loggable
    }
  }
}

object Application {
  def main(agrs: Array[String]) {
    val f1 = Fraction(3, 8)
    val f2 = Fraction(4, 10)
    val f3 = Fraction(1, 19, loggable = true)
    val f1f2 = f1 * f2
    println(f1.toString + " * " + f2.toString + " = " + f1f2)
    println(f3.toString + " * " + f2.toString + " * " + f1.toString + " = " + f3 * f2 * f1)
  }
}