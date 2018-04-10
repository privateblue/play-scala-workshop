object ADTs {

  // linked list

  sealed trait List[+T] {
    def map[U](fn: T => U): List[U] =
      this match {
        case Cons(head, tail) => Cons(fn(head), tail.map(fn))
        case Nil => Nil
      }
  }
  final case class Cons[T](head: T, tail: List[T]) extends List[T]
  final case object Nil extends List[Nothing]

  // missing value

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