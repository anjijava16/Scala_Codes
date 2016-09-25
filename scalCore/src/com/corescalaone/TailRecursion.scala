package com.corescalaone

import scala.io.StdIn

object TailRecursion {

  def main(args: Array[String]): Unit = {
    print("Enter n value : ")
    val n = StdIn.readInt()
    var res = 1;
    println("factorial(n) :: " + factorial(n))
    println("factorial(res, n) :: " + factorial(res, n))

    var listOfInt = Array(15, 35, 34, 29)

    // Print all the array elements
    println("List of elements : ")
    for (xLoc <- listOfInt) {
      println(xLoc)
    }
    println("List of elements : ")
    for (i <- 0 until listOfInt.length) {
      println(listOfInt(i))
    }
    
    // print MAX value of Int Array
    println("Max of listOfInt : " + maxOfInts(listOfInt))
    listOfInt.update(0, 49)
    println("Max of listOfInt : " + maxOfInts(listOfInt))
    
    
    val a :: b :: c :: d :: e = "1 2 3 4 5".split(" ").toList
    println(e)
    val f  = "1 2 3 4 5".split(" ").toList
    println(f)
  }

  // normal recursion in Scala
  def factorial(number: Int): Int = {
    if (number > 0) {
      if (number == 1)
        return 1
      number * factorial(number - 1)
    } else
      0
  }

  def factorial(res: BigInt, number: Int): BigInt = {
    if (number > 0) {
      if (number == 1) {
        return res
      } else {
        //Tail Recursion in Scala
        factorial(res * number, number - 1)
      }
    } else
      0
  }

  // Finding the largest element
  def maxOfInts(listOfInt: Array[Int]): Int = {
    var max = listOfInt(0);
    for (i <- 1 to (listOfInt.length - 1)) {
      if (listOfInt(i) > max)
        max = listOfInt(i);
    }
    max
  }

}

/**
 * Note: 
 * In the recursion example, notice how the result of each call must be remembered, to do this each recursive call requires an entry on the stack until all recursive calls have been made.
 * This makes the recursive call more expensive in terms of memory. 
 * While in the tail recursive example, there are no intermediate values that need to be stored on the stack, the intermediate value is always passed back as a parameter.
 * 
 */




/*
  
OUTPUT
------

Enter n value : 5
factorial(n) :: 120
factorial(res, n) :: 120
List of elements : 
15
35
34
29
List of elements : 
15
35
34
29
Max of listOfInt : 35
Max of listOfInt : 49
List(5)
List(1, 2, 3, 4, 5)

*/
