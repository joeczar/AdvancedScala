package lectures.part1as

object AdvancedPM extends App {

  val numbers = List(1)
  val description = numbers match {
    case head :: Nil => s"The only element is $head"
    case _ =>
  }

  /*
  - constants
  - wildcards
  - case classes
  - tuples
  - some special magic like above
   */
  // if for some reason you cannot make your class a case class:
  class Person(val name: String, val age: Int)

  object Person {
    /*
    the unapply method takes the argument that is being pattern matched against - (person: Person) or (age: Int)
    and returns the output of the unapply method which will be processed after pattern matching.
     */
    def unapply(person: Person): Option[(String, Int)] =
      if (person.age < 21) None
      else Some((person.name, person.age))

    def unapply(age: Int): Option[String] = {
      Some(if (age < 21) "minor" else "adult")
    }
  }

  val bob = new Person("Bob", 24)
  val greeting = bob match {
    case Person(n, a) => s"Sup bitches, I'm $n and I is $a years old"
  }
  println(greeting)

  val legalStatus = bob.age match {
    case Person(status) => s"I am a $status"
  }
  println(legalStatus)

  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }
  object singleDigit {
    def unapply(arg: Int): Boolean = arg < 10
  }

  val n: Int = 9
  val mathProperty = n match {
    case even() => "even number"
    case singleDigit() => "single digit"
    case _ => "no property"
  }
  println(mathProperty)
}
