class NonEmpty5(default: Int) {
  private var items: List[Int] = List(default)

  def |+|(n: Int): Unit = {
    items = items :+ n
  }

  def from(xs: List[Int]): List[Int] = items ++ xs sorted

  private def defaults = from(List.empty)
}

// companion has access to private members

object NonEmpty5 {
  def simple = new NonEmpty5(0).defaults
}

// apply method: you can call it by GCD(15,12)

object GCD {
  def apply(a: Int, b: Int): Int = if (b == 0) a else apply(b, a % b)
}

// apply usually used as factory methods

object NE {
  def apply(n: Int) = new NonEmpty5(n)
}

// convention is to put factory apply in companion object