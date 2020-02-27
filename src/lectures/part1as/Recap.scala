package lectures.part1as

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionedVal = if(aCondition) 42 else 65
  // Instructions vs expressions

  // compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // Unit == Void in other languages
  val theUnit = println("Hello, Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail

  @scala.annotation.tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n<=0) acc
    else factorial(n-1, n + acc)

  // object orientation
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Croc extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("Snap!")
  }

  val aCroc = new Croc
  aCroc.eat(aDog)
  aCroc eat aDog

  1 + 2
  1.+(2) // these are the same because + is a method

  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("Roar!")
  }

  // generics

  abstract class MyList[+A]// variance & variance problems coming in this course
  // singletons and companions
  object MyList

  case class Person(name: String, Age: Int)

  // exceptions, try, catch finally
  //val throwsException = throw new RuntimeException("Bam!") // Type = Nothing
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("some logs")
  }

  // packaging and Imports
  // Functional Programming

  val incrementer = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  println(incrementer(1))

  val anonIncrement = (x: Int) => x + 1
  println(List(1,2,3,4,5).map(anonIncrement)) // HOF
  // map flatMap filter

  // for comprehension
  val pairs = for {
    num <- List(1,2,3) // if condition
    char <- List('a', 'b', 'c')
  } yield s"$num-$char"
  println(pairs)

  // Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 234
  )

  // collections: Options, Try
  val anOption = Some(2)

  // Pattern Matching Switch on steroids


}



