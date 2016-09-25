package com.corescalaone

import scala.io.StdIn
import java.util.{ Locale, Date }
import java.text.DateFormat._

object HelloWorld {
  def main(args: Array[String]): Unit = {
    // Not mandatory to call functions inside main()

    println("Enter a i value: ")
    val i = StdIn.readDouble

    val now = new Date
    val df = getDateInstance(LONG, Locale.ENGLISH)
    println(df format now)
  }

  def multiple(x: Double, y: Double): Int = { if (x <= 0 || y <= 0) 0 else x.toInt * y.toInt }

  def square(i: Double): Double = { if (i <= 0) 0 else i * i }

  def quadrant(x: Double, y: Double): Int = {
    if (x < 0) {
      if (y < 0) 3 else 2
    } else {
      if (y < 0) 4 else 1
    }
  }

  println("Enter an x-coordinate: ")
  val x = StdIn.readDouble()
  println("Enter an y-coordinate: ")
  val y = StdIn.readDouble()
  println("def multiple :: " + multiple(x, y))
  println("def square :: " + square(x))
  println("def quadrant :: " + quadrant(x, y))

  //Numbers are objects
  println(1 + 2 * 3 / 4)
  println((1).+(((2).*(3))./(4)))
  println(1.+((2.*(3))./(4)))

  /**
   * http://docs.scala-lang.org/tutorials/scala-for-java-programmers.html
   * http://docs.scala-lang.org/cheatsheets/
   * http://docs.scala-lang.org/glossary/
   * http://docs.scala-lang.org/tutorials/
   * http://docs.scala-lang.org/overviews/
   * http://www.scala-lang.org/api/current/#package
   * http://docs.scala-lang.org/index.html
   *
   *
   * Note:
   * Everything is an Object
   * Scala is a pure object-oriented language in the sense that everything is an object, including numbers or functions.
   * It differs from Java in that respect, since Java distinguishes primitive types (such as boolean and int) from reference types, and does not enable one to manipulate functions as values.
   */

}


/*

OUTPUT
------

Enter an x-coordinate: 
1
Enter an y-coordinate: 
2
def multiple :: 2
def quadrant :: 1
2
2
2
Enter a i value: 
3
def square :: 9.0
February 11, 2016

*/