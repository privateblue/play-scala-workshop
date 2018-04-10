// val's and def's share the same namespace, val's can override def's
// also, spot the difference between members and constructor parameters

trait DefaultValue2 {
  def default: Int
}

class NonEmptyImpl2(val default: Int) extends DefaultValue2 with NonEmpty2 with Sorting {
  override def from(xs: List[Int]): List[Int] = sort(List(default) ++ xs)
}
