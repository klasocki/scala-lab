package lab2

import scala.beans.BeanProperty

class PersonScala(protected val id: String, val givenName: String, @BeanProperty var surname: String) {
  def getName: String = givenName + " " + surname
}
