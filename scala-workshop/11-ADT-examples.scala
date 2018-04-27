object ADTs {

  // linked list (type to represent zero or more values of the same type)

  sealed trait List[+T]
  final case class Cons[T](head: T, tail: List[T]) extends List[T]
  final case object Nil extends List[Nothing]

  def map[T, U](list: List[T])(fn: T => U): List[U] =
    list match {
      case Cons(head, tail) =>
        val h = fn(head)
        val t = map(tail)(fn)
        Cons(h, t) // NOT tail-recursive!

      case Nil => Nil
    }




















  // missing value (type to represent zero or one value of the same type)

  sealed trait Option[+T] {
    def map[U](fn: T => U): Option[U] =
      this match {
        case Some(value) => Some(fn(value))
        case None => None
      }
  }
  final case class Some[T](value: T) extends Option[T]
  final case object None extends Option[Nothing]

}