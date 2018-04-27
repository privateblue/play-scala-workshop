// basic case

class NonEmpty(default: Int) {
  def from(xs: List[Int]): List[Int] = List(default) ++ xs sorted
}





























// traits, classes, multiple inheritance

abstract class DefaultValue(default: Int)

trait Sorting {
  def sort(xs: List[Int]): List[Int] = xs.sorted
}

trait NonEmpty2 {
  def from(xs: List[Int]): List[Int]
}

class NonEmptyImpl(default: Int) extends DefaultValue(default) with NonEmpty2 with Sorting {
  override def from(xs: List[Int]): List[Int] = sort(List(default) ++ xs)
}

object WithZero extends NonEmptyImpl(0)
