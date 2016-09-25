package com.corescalaone

import scala.util.Random
import java.util.Date

/**
 * nameBy && valueBy
 */
object HigherOrderFunctions {

  def main(args: Array[String]): Unit = {

    /**
     * Scala Functions Call-by-Name
     *
     * def layout(x: Int) : String
     * layout: Int => String
     */
    class Decorator(left: String, right: String) {
      def layoutVal(x: Int) = left + x + right
    }
    def apply(layoutFn: Int => String, v: Int) = layoutFn(v + 3)
    val decorator = new Decorator("[", "]")
    println(apply(decorator.layoutVal, 7))

    def timeMe() = {
      println("Getting time in nano seconds")
      System.nanoTime
    }
    def delayed(timeMeFn: => Long) = {
      println("Inside delayed method")
      println("Param: " + timeMeFn)
      timeMeFn
    }
    println(delayed(timeMe()));

    /**
     * Scala Functions with Named Arguments
     * Named arguments allow you to pass arguments to a function in a different order.
     */
    def printInt(a: Int, b: Int) = {
      println("a & b - " + a + " & " + b);
    }
    printInt(b = 5, a = 5);
    printInt(a = 7, 3);

    /**
     * Scala Function with Variable Arguments
     * Scala allows you to indicate that the last parameter to a function may be repeated. This allows clients to pass variable length argument lists to the function.
     */
    def printVarStrings(strs: String*) = {
      for (str <- strs) println(str)
    }
    printVarStrings("Hello", "Scala", "world");

    /**
     * Tail recursion
     *
     */
    def factorialOne(res: BigInt, number: Int): BigInt = {
      if (number > 0) {
        if (number == 1) {
          return res
        } else {
          //Tail Recursion in Scala
          factorialOne(res * number, number - 1)
        }
      } else
        0
    }
    def factorialTwo(i: Int): BigInt = {
      def fact(accumulator: BigInt, i: Int): BigInt = {
        if (i == 1)
          accumulator
        else
          fact(i * accumulator, i - 1)
      }
      //Scala Nested Functions
      fact(1, i)
    }
    println("Tail recursion - factorialOne : " + factorialOne(1, 5))
    println("Tail recursion - factorialTwo : " + factorialTwo(5))

    /**
     * Scala Default Parameter Values for a Function
     */
    def addTwoInts(a: Int = 5, b: Int = 5): Long = {
      return a + b
    }

    /**
     * Scala Anonymous Functions
     */
    var multiplicationOfXY = (x: Int, y: Int) => x * y
    println("multiplicationOfXY : " + multiplicationOfXY(2, 5))

    /**
     * Scala Partially Applied Functions
     * we first bind a value to the date parameter and leave the second parameter unbound by putting an underscore at its place.
     */
    def log(date: Date, message: String) = {
      println(date + " : " + message)
    }
    val date = new Date
    val logWithDateBound = log(date, _: String)
    logWithDateBound("log4j msg1")
    Thread.sleep(1000)
    logWithDateBound("log4j msg2")
    Thread.sleep(1000)
    logWithDateBound("log4j msg3")

    /**
     * Scala Closures
     * A closure is a function, whose return value depends on the value of one or more variables declared outside this function.
     */
    val factor = 5
    // here, i, is a formal parameter to the function. 
    val multiplier = (i: Int) => i * factor
    println(multiplier(2))

    val set = (1 to 5).toSet
    set.foreach { println }

    def isEven(e: Int): Boolean = { e % 2 == 0 }
    //1. higher-order functions — functions that take functions as parameters(arguments) — which gives you extra opportunities to condense and simplify code.
    val evenSet = set.filter(i => isEven(i))
    evenSet.foreach { println }

    def randomString(length: Int) = Random.alphanumeric.take(length).mkString
    var ranStrlist = List(randomString(5))
    for (i <- 0 until 5) ranStrlist.:+=(randomString(5))
    ranStrlist.foreach { println }

    //2. Higher Order Functions - that take functions as return statement
    def capitalize(str: String): String = {
      def strUL() = str.head.toUpper + str.tail.toLowerCase()
      strUL()
    }
    ranStrlist = ranStrlist.map { s => capitalize(s) }
    println("------capitalize-----")
    ranStrlist.foreach { println }

    //Tests whether a predicate holds for some of the elements of this list. - exists
    val nums = (-1 to 5).toList
    def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
    println("exists : " + containsNeg(nums))

    //Currying
    def curriedSumOne(x: Int)(y: Int) = x + y
    println("curriedSumOne : " + curriedSumOne(1)(2))

    def curriedSumTwo(x: Int) = (y: Int) => x + y
    println("curriedSumTwo : " + curriedSumTwo(1)(2))

    for (i <- (1 to 10).reverse) {
      println("i th element is: " + i);
    }
    for (i <- 10 to (1, -1)) {
      println("i th element is: " + i);
    }

  }

}


/*

OUTPUT:
------
[10]
Inside delayed method
Getting time in nano seconds
Param: 873289484787055
Getting time in nano seconds
873289484864195
a & b - 5 & 5
a & b - 7 & 3
Hello
Scala
world
Tail recursion - factorialOne : 120
Tail recursion - factorialTwo : 120
multiplicationOfXY : 10
Thu Feb 25 20:11:55 IST 2016 : log4j msg1
Thu Feb 25 20:11:55 IST 2016 : log4j msg2
Thu Feb 25 20:11:55 IST 2016 : log4j msg3
10
5
1
2
3
4
2
4
byE1x
zXolv
BseIe
ZSzwo
mwLAe
MXtoy
------capitalize-----
Bye1x
Zxolv
Bseie
Zszwo
Mwlae
Mxtoy
exists : true
curriedSumOne : 3
curriedSumTwo : 3
i th element is: 10
i th element is: 9
i th element is: 8
i th element is: 7
i th element is: 6
i th element is: 5
i th element is: 4
i th element is: 3
i th element is: 2
i th element is: 1
i th element is: 10
i th element is: 9
i th element is: 8
i th element is: 7
i th element is: 6
i th element is: 5
i th element is: 4
i th element is: 3
i th element is: 2
i th element is: 1

*/