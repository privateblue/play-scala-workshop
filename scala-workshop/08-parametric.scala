class NonEmpty6[T](val head: T) {
  def from(xs: List[T]): List[T] = List(head) ++ xs
}

object NonEmpty6 {

  def apply[T](head: T): NonEmpty6[T] = new NonEmpty6(head)

  def size[T](list: NonEmpty6[T]): Int = ???

}