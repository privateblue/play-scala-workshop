class NonEmpty3(default: Int) {
  private var items: List[Int] = List(default)

  def add(n: Int): Unit = {
    items = items :+ n
  }

  def from(xs: List[Int]): List[Int] = items ++ xs sorted
}
