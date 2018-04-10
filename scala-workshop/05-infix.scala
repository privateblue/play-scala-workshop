class NonEmpty4(default: Int) {
  private var items: List[Int] = List(default)

  def |+|(n: Int): Unit = {
    items = items :+ n
  }

  def from(xs: List[Int]): List[Int] = items ++ xs sorted
}
