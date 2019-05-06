sealed trait T1 {
  def f(i: Int): Unit
}

class C1 extends T1 {
  def f(i: Int): Unit = { println(i) }
}

object CaseAppl {
  def main(args: Array[String]) {
    (new C1).f(3)
  }
}