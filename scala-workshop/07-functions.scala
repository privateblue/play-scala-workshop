object functions {

  // defining and calling methods

  def foo(a: Boolean, b: String, c: Int): (Boolean, String, Int)
    = (a, b, c)

  foo(true, "hello", 3)

  foo(b = "world", c = 7, a = false)

  def bar(a: Boolean) // : (String, Int) => (Boolean, String, Int)
    = foo(a, (_: String), (_: Int))





















  // higher order functions

  def double1(n: Int): Int
    = n * 2

  val double2: Int => Int
    = (n: Int) => n * 2

  def quadruple(n: Int, doubler: Int => Int): Int
    = doubler(doubler(n))

  quadruple(3, double1)
  quadruple(3, double2)

  // BUT

  val double3 = double1 _

  // UNLESS

  val double4: Int => Int = double1













  // map

  List(1, 2, 3).map(n => n * 2)

  List(1, 2, 3).map(_ * 2)

  // filter

  List(1, 2, 3).filter(n => n % 2 == 0)

  List(1, 2, 3).filter(_ % 2 == 0)

  // flatMap

  val count: Int => List[Int]
    = n => 1 to n toList

  List(1, 2, 3).flatMap(n => count(n))

  List(1, 2, 3).flatMap(count(_))

  List(1, 2, 3).flatMap(count)

  // reduce, fold

  List(1, 2, 3).reduce((a, b) => a + b)

  List(1, 2, 3).reduce(_ + _)

  List(1, 2, 3).foldLeft(0)((a, b) => a + b)

  List(1, 2, 3).foldLeft(0)(_ + _)

  // callbacks, loan pattern

  class Connection {
    def open(): Unit = ???
    def close(): Unit = ???
    def send(msg: String): Unit = ???
  }

  def withConnection(c: Connection, task: Connection => Unit): Unit = {
    c.open()
    try {
      task(c)
    } finally {
      c.close()
    }
  }

  val c = new Connection

  def greet(greeting: String) = withConnection(c, c => c.send(greeting))

  // multiple parameter lists

  def withConnection2(c: Connection)(task: Connection => Unit): Unit = {
    c.open()
    try {
      task(c)
    } finally {
      c.close()
    }
  }

  def greet2(greeting: String) = withConnection2(c) {
    c => c.send(greeting)
  }
}