def sumArrayRec(elems: Array[Int]) = {
  @annotation.tailrec
  def goFrom(i: Int, size: Int, elms: Array[Int], acc: Int): Int = {
    if (i < size) goFrom(i + 1, size, elms, acc + elms(i))
    else acc
  }
  goFrom(0, elems.length, elems, 0)
}

def sumArrayClosure(elems: Array[Int]): Int = {
  @annotation.tailrec
  def goFrom(i: Int, acc: Int): Int = {
    if (i >= 0) goFrom(i - 1, acc + elems(i))
    else acc
  }
  goFrom(elems.length - 1, 0)
}
Array(1,2,3)