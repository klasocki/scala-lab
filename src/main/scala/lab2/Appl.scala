package lab2

object Appl {
  def main(args: Array[String]): Unit = {
    val p = new PersonScala("124124", "Akka", "Kowalski")
    println(p.getSurname)
    p.setSurname("lalala")
    println(p.getName)
  }
}
