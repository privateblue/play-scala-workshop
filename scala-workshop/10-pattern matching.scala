object patternmatching {

  // resembles switch statements, but more powerful

  val n = 3

  val verdict: String =
    n match {
      case 0 => "zero"
      case 1 => "one"
      case _ => "more"
    }

  def isPerson(x: Any): String =
    x match {
      case x: Person => "case class"
      case x: Person2 => "plain class"
      case _ => "not even a person"
    }

  var p2s = List.empty[Person2]

  def greet(x: Any): String =
    x match {

      case Person(first, last) =>
        "Hello " + first + " " + last

      case p @ Person2(first, last) =>
        p2s = p2s :+ p
        "Yo " + first + " " + last

      case _ =>
        "Erm..."

    }

  // guards and wildcards

  var jimmies = List.empty[Person2]

  def greet2(x: Any): String =
    x match {

      case Person(first, last) =>
        "Hello " + first + " " + last

      case p @ Person2(first, _) if first == "Jimmy" =>
        p2s = p2s :+ p
        jimmies = jimmies :+ p
        "Yo Jimmy"

      case _ =>
        "Erm..."

    }

  // some sample data

  val p1 = Person("Stephen", "Colbert")
  val p2 = Person2("Seth", "Meyers")
  val p3 = Person2("Jimmy", "Kimmel")
  val p4 = Person2("Jimmy", "Fallon")
  val p5 = Person("Conan", "O'Brien")







  // sealed traits, ADTs

  /*sealed */trait Position
  /*final  */case class Former(startYear: Int, endYear: Int) extends Position
  /*final  */case class Current(startYear: Int) extends Position

  def length(p: Position): Int =
    p match {
      case Former(s, e) => e - s
      case Current(s) => 2018 - s
      case _ => 0 // this is not needed if Position is sealed
    }

  def sumLength(ps: List[Position]): Int = ps.map(length).sum



















  // partial functions

  def sumLength2(ps: List[Position]): Int = {
    val ls = ps.map {
      case Former(s, e) => e - s
      case Current(s) => 2018 - s
    }
    ls.sum
  }

  val formers: PartialFunction[Position, Int] = {
    case Former(s, e) => e - s
  }

  def sumLength3(ps: List[Position]): Int =
    ps.collect(formers).sum

}