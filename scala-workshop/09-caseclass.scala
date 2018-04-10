case class Person(firstName: String, lastName: String)

// is syntactic sugar for

class Person2(val firstName: String, val lastName: String) extends Serializable {
  def copy(fn: String = firstName, ln: String = lastName) = Person2(fn, ln)
  override def toString = "Person2(" + firstName + ", " + lastName + ")"
}

object Person2 {
  def apply(firstName: String, lastName: String) = new Person2(firstName, lastName)
  def unapply(p: Person2): Option[(String, String)] = Some((p.firstName, p.lastName))
}

// case classes are mostly used as records
// in contrast to tuples

object tuples {

  val pair1: (Int, Int) = (1, 2)

  val pair2: (Int, Int) = 1 -> 2

  val pair3: (Int, Int) = new Tuple2[Int, Int](1, 2)

  val ntuple: (Int, String, Byte, Boolean, Double) = (1, "hello", 2, false, 0.334D)

  def toTuple(p: Person): (String, String) = Person.unapply(p).get

}