package lectures.part1as

import scala.util.Try

object DarkSugars extends App {

  // syntax sugar #1: Methods with single paramaters
  def singleArgMethod(n: Int): String = s"$n little ducks"

  val description = singleArgMethod {
    // Write some code
    42
  }
  def aTryInstance = Try {
    throw new Exception("Bim zalla bim! That didn't work")
  }

  List(1, 2, 3, 4).map { x =>
    x + 1
  }
  // syntax #2: single abstract method
  trait Action {
    def act(x: Int): Int
  }
  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }
  val anotherInstance: Action = (x: Int) => x + 1

  // examples: Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello Scala")
  })
  val aSweeterThread = new Thread(() => println("Sweet, Scala!"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(A: Int): Unit
  }
  val anAbstractInstance: AnAbstractType = (a: Int) => println("Sweet")
  // syntax #3: :: and #:: methods are special
  val prependedList = 2 :: List(3,4)
  // 2.::(List(3,4))
  // List(3,4).::(2)

  // Scala spec: last char decides  associativity of method
  1 :: 2 :: 3 :: 4 :: List(5, 6)
  List(5,6).::(4).::(3).::(2).::(1)

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this // actual implementation here
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]
  // Syntax sugar number 4: multi word method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
  }
  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is soooo sweet!"

  // syntax sugar #5 infix types
  class Composite[A, B]
  val composite: Int Composite String = ???

  class -->[A, B]
  val towards: Int --> String = ???

  // Syntax sugar #6 update() very special, much like apply
  val anArray = Array(1,2,3)
  anArray(2) = 7 // == anArray.update(index = 2, newVal = 7)
  // used in mutable collections
  // remember apply() and update()

  // Syntax sugar number 7 getters and setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member: Int = internalMember // getter
    def member_=(value: Int): Unit =
      internalMember = value // setter
  }
  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // == aMutableContainer.member_=(42)



}
