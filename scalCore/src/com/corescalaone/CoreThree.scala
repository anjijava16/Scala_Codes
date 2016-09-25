package com.corescalaone

// Pizza class
class Pizza(var crustType: String) {
  val pizzaVendor = "PizzaHut"
  override def toString = "Crust type is " + crustType
}

// companion object
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
}
class MyString(val jString: String) {
  private var extraData = ""
  override def toString = jString + extraData
}
object MyString {
  def apply(jString: String, extras: String) = {
    val s = new MyString(jString)
    s.extraData = extras
    s
  }
  def apply(jString: String) = new MyString(jString)
}
object CoreThree {
  def main(args: Array[String]): Unit = {

    println(Pizza.CRUST_TYPE_THIN)
    var pOne = new Pizza(Pizza.CRUST_TYPE_THICK)
    var pTwo = new Pizza(Pizza.CRUST_TYPE_THICK)
    var pObjOne = Pizza
    var pObjTwo = Pizza
    var pThree = new Pizza(Pizza.CRUST_TYPE_THICK)
    println(pOne)
    println(Pizza.getFoo)
    //589431969 1252169911 2101973421
    println(pObjOne.hashCode + " == " + pObjTwo.hashCode + " || " + pOne.hashCode + " != " + pTwo.hashCode)
    println(pOne.pizzaVendor)
    println(MyString("hello", " world"))
    println(MyString("hello"))

    //singleton call
    println(com.corescalaone.SumOfList.sum(List(1, 2, 3)))

    //Case Classes
    val summation = new Summation(20, 10)
    val summationDoArithmatic: Arithmatic = ArithmaticCaseClass.doArithmatic(summation)
    println(summationDoArithmatic.doArithmatic)
    val multiplication = new Multiplication(20, 10)
    val multiplicationDoArithmatic: Arithmatic = ArithmaticCaseClass.doArithmatic(multiplication)
    println(multiplicationDoArithmatic.doArithmatic)
    val division = new Division(20, 10)
    val divisionDoArithmatic: Arithmatic = ArithmaticCaseClass.doArithmatic(division)
    println(divisionDoArithmatic.doArithmatic)
    val subtraction = new Subtraction(20, 10)
    val subtractionDoArithmatic: Arithmatic = ArithmaticCaseClass.doArithmatic(subtraction)
    println(subtractionDoArithmatic.doArithmatic)
  }
}

/**
 * Case Classes
 * Scala supports the notion of case classes. Case classes are regular classes which export their constructor parameters
 * The constructor parameters of case classes are treated as public values and can be accessed directly.
 * It only makes sense to define case classes if pattern matching is used to decompose data structures.
 */
abstract class Arithmatic {
  def doArithmatic: Long
}
case class Summation(x: Int, y: Int) extends Arithmatic {
  def doArithmatic(): Long = {
    println("Summation")
    x + y
  }
}
case class Multiplication(x: Int, y: Int) extends Arithmatic {
  def doArithmatic(): Long = {
    x * y
  }
}
case class Division(x: Int, y: Int) extends Arithmatic {
  def doArithmatic(): Long = {
    x / y
  }
}
case class Subtraction(x: Int, y: Int) extends Arithmatic {
  def doArithmatic(): Long = {
    x - y
  }
}

object ArithmaticCaseClass {
  var result: Arithmatic = null
  def doArithmatic(arithmatic: Arithmatic): Arithmatic = {
    arithmatic match {
      case Summation(x, y)      => { result = new Summation(x, y) }
      case Multiplication(x, y) => { result = new Multiplication(x, y) }
      case Division(x, y)       => { result = new Division(x, y) }
      case Subtraction(x, y)    => { result = new Subtraction(x, y) }
    }
    result
  }

  def matchInt(x: Int): Unit = x match {
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("many")
  }
  def matchAny(x: Any): Any = x match {
    case 1      => "one"
    case "two"  => 2
    case y: Int => "scala.Int"
  }
  matchInt(3)
  println(matchAny("two"))

}



/*

OUTPUT:
------

thin
Crust type is thick
Foo
589431969 == 589431969 || 1252169911 != 2101973421
PizzaHut
hello world
hello
6
many
2
Summation
30
200
2
10


*/