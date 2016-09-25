package com.corescalaone

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import scala.collection.mutable.MutableList
import scala.io.Source
import java.io.FileReader
import java.io.BufferedReader

object FunctionsClosures {

  def main(args: Array[String]): Unit = {

    //1. Placeholder syntax
    val strList = "1 2 3 0 4 5".split(" ").toList
    strList.filter(_ != "0").foreach { x => println(x) }

    val source: BufferedReader = Source.fromURL(getClass.getResource("Authors.csv")).bufferedReader()

    val authorList = loadAuthorsFromFile(source)
    authorList.foreach { println }
    println("-----------------authorList.sorted-----------------------")
    authorList.sorted.foreach { println }
  }

  //2. First-class functions - function definition inside function
  def loadAuthorsFromFile(source: BufferedReader): MutableList[Author] = {
    var authorList: MutableList[Author] = MutableList[Author]()
    try {
      for (line <- Iterator.continually(source.readLine()).takeWhile(_ != null)) {
        val authorArr = line.split(",")
        val author: Author = new Author(authorArr(0).toInt, authorArr(1), authorArr(2))
        authorList += author
      }
    } catch {
      case ex: FileNotFoundException => println("FileNotFoundException : " + ex)
      case ex: IOException           => println("IO Exception : " + ex)
    } finally {
      println("OK")
    }
    authorList
  }

  //3. Closures - function literals have referred only to passed parameters.
  //the only variable used in the function body, x > 0, is x, which is defined as a parameter to the function.
  def xClosures = (x: Int) => { x + 10 }
  println(xClosures(10))
  var sumListOfNums = 0
  val listOfNums = List(1, 2, 3, 4, 5)
  listOfNums.foreach(sumListOfNums += _)
  println(sumListOfNums)

  // 4. Repeated parameters - variable arguments 
  def echo(strArgs: String*) = for (strArg <- strArgs) println(strArg)
  echo("hello!", "world!!")

  //5 . Default parameter values
  def getDefaultStr(defaultStr: String = "nothing"): Unit = { println(defaultStr) }
  getDefaultStr()

  /**
   * 6. Tail recursion
   *
   * def boom(x: Int): Int =
   * if (x == 0) throw new Exception("boom!")
   * else boom(x 1) + 1
   * This function is not tail recursive, because it performs an increment operation after the recursive call.
   *
   */
  def tailRecursionOne(x: Int): Int =
    if (x == 0) throw new Exception("tailRecursion!!")
    else {
      println("tailRecursionOne : " + x)
      tailRecursionOne(x - 1) // last call should be the same function call
    }
  try {
    tailRecursionOne(3)
  } catch {
    case ex: Exception => println("Exception : " + ex)
  } finally {
    println("OK")
  }

  def tailRecursionTwo(x: Int): Int =
    if (x == 0) x
    else {
      println("tailRecursionTwo : " + x)
      tailRecursionTwo(x - 1) // last call should be the same function call
    }
  tailRecursionTwo(3)
}


/*

OUTPUT:
------
20
15
hello!
world!!
nothing
tailRecursionOne : 3
tailRecursionOne : 2
tailRecursionOne : 1
Exception : java.lang.Exception: tailRecursion!!
OK
tailRecursionTwo : 3
tailRecursionTwo : 2
tailRecursionTwo : 1
1
2
3
4
5
OK
5 shatrughna ayodhya
6 hanuma kishkinda
7 sriram ayodhya
1 sriram ayodhya
2 seeta midhila
3 lakshman ayodhya
4 bharatha ayodhya
-----------------authorList.sorted-----------------------
4 bharatha ayodhya
6 hanuma kishkinda
3 lakshman ayodhya
2 seeta midhila
5 shatrughna ayodhya
1 sriram ayodhya
7 sriram ayodhya


*/
