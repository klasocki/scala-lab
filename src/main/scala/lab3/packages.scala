package lab3

import p1.p2.C2._

object AppPackage  {
  import p1._
  new C1
  import p2.{C21, C22=>MyC22, C23=>_}
  new C21
//  new C22
  new MyC22
//  new C23
  def main(args: Array[String]) {
    m1OC2()
    m2OC2(new C1)
  }
}