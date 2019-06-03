object AppRecDepth {
  def recurseTest(i: Int, j: Int, arr: Array[Int]): Int = {
    try {
      recurseTest(i + 1, j + 1, arr)
    } catch {
      case e: java.lang.StackOverflowError =>
        println("Recursion depth on this system is " + i + ".")
        i
    }
  }

  def main(args: Array[String]) {
    recurseTest(0, 0, Array(1))
  }
}