package com.corescalaone

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

import scala.collection.mutable.MutableList
import scala.io.Source

object ComparableOne {

  def main(args: Array[String]): Unit = {
    // FileNotFoundException : java.io.FileNotFoundException: Authors.csv (The system cannot find the file specified)
    val afile: java.io.File = new File("D:/thanooj/work/Workspaces/WSscala/WSOne/CoreScalaNew/resources/Authors.csv")

    val authorList = loadAuthorsFromFile(afile)
    authorList.foreach { println }
    println("-----------------authorList.sorted-----------------------")
    authorList.sorted.foreach { println }
  }

  def loadAuthorsFromFile(afile: java.io.File): MutableList[Author] = {
    var authorList: MutableList[Author] = MutableList[Author]()
    try {
      //val fileLines = io.Source.fromFile("Colors.scala").getLines.toList
      for (line <- Source.fromFile(afile).getLines()) {
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
}



/**
 * 
 * NOTE:
 * 
 * val fileLines = io.Source.fromFile("Colors.scala").getLines.toList
 * fileLines.foreach(println)
 *
 * val reader = new FileReader("foo.txt")
 *
 * val writer = new PrintWriter(new File("Write.txt"))
 *
 * writer.write("Hello Developer, Welcome to Scala Programming.")
 * writer.close()
 */



/*

OUTPUT:
------

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