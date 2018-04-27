object parametric {

  // class/trait type parameters, in contract to type members in 03-members

  class NonEmpty6[T](val head: T) {
    def from(xs: List[T]): List[T] = List(head) ++ xs
  }

  // so a function type is syntactic sugar

  val double1: Int => Int = ???

  val double2: Function1[Int, Int] = ???





















  // function type parameters

  object NonEmpty6 {

    def apply[T](head: T): NonEmpty6[T] = new NonEmpty6(head)

    def size[T](list: NonEmpty6[T]): Int = ???

  }

  // same example from 07-funtions, but parameterized

  def foo[A, B](a: A, b: B, c: Int): (A, B, Int)
    = (a, b, c)

  foo(true, "hello", 3) // : (Boolean, String, Int)

  foo(b = new NonEmpty3(0), c = 7, a = ()) // : (Unit, NonEmpty3, Int)

  def bar[A, B](a: A) // : (B, Int) => (A, B, Int)
    = foo[A, B](a, (_: B), (_: Int))
}