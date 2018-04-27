// val's and def's must always exist inside an object (i.e. must have a path)
// val's and def's share the same namespace, val's can override def's
// also, spot the difference between members and constructor parameters

trait DefaultValue2 {
  type T
  def default: T
}

class NonEmptyImpl2(val default: Int) extends DefaultValue2 with NonEmpty2 with Sorting {
  type T = Int
  override def from(xs: List[T]): List[T] = sort(List(default) ++ xs)
}
