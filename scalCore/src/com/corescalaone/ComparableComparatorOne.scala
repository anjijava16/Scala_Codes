package com.corescalaone

import java.io.FileNotFoundException
import java.io.IOException
import scala.collection.mutable.MutableList
import scala.io.Source
import java.io.File
import java.util.Comparator

object ComparableComparatorOne {

  def main(args: Array[String]): Unit = {
    val afile: java.io.File = new File("D:/thanooj/work/Workspaces/WSscala/WSOne/CoreScalaNew/resources/Authors.csv")
    val authorList = getListOfAuthorsFromFile(afile)

    authorList.foreach { println }
    sortOnAuthorList(authorList)
  }

  def sortOnAuthorList(authorList: MutableList[Author]): Unit = {
    println("-----------------authorList.sorted-----------------------------------  ")
    authorList.sorted.foreach { println }
    println("-----------------authorList.reverse----------------------------------  ")
    authorList.reverse.foreach { println }

    println("-----------------sortWith------_.compareTo(_) < 0--------------------  ")
    authorList.sortWith(_.compareTo(_) < 0).foreach { println }
    println("-----------------sortWith------_.compareTo(_) > 0--------------------  ")
    authorList.sortWith(_.compareTo(_) > 0).foreach { println }

    println("-----------Author.Ordering.by(e => e.id)--------orderingById----------  ")
    authorList.sorted(Author.orderingById).foreach { println }
    println("---------Author.Ordering.by(e => e.name)--------orderingByName--------  ")
    authorList.sorted(Author.orderingByName).foreach { println }
    println("-----Author.Ordering.by(e => e.location)--------orderingByLocation----  ")
    authorList.sorted(Author.orderingByLocation).foreach { println }
    println("-Author.Ordering.by(e => (e.location, e.name, e.id)-orderingByNameThenLocation- ")
    authorList.sorted(Author.orderingByNameThenLocationThanId).foreach { println }

    val orderingByName: Ordering[Author] = Ordering.by(a => (a.name))
    val orderingByLocation: Ordering[Author] = Ordering.by(a => (a.location))
    val orderingById: Ordering[Author] = Ordering.by(a => (a.id))
    val orderingByNameThenLocationThanId: Ordering[Author] = Ordering.by(e => (e.location, e.name, e.id))

    println("-----------------Ordering.by(e => e.id)--------orderingById------------  ")
    authorList.sorted(orderingById).foreach { println }
    println("----------------Ordering.by(e => e.name)--------orderingByName----------  ")
    authorList.sorted(orderingByName).foreach { println }
    println("------------Ordering.by(e => e.location)--------orderingByLocation------  ")
    authorList.sorted(orderingByLocation).foreach { println }
    println("--Ordering.by(e => (e.location, e.name, e.id)-orderingByNameThenLocation- ")
    authorList.sorted(orderingByNameThenLocationThanId).foreach { println }
  }

  def getListOfAuthorsFromFile(afile: java.io.File): MutableList[Author] = {
    var authorList: MutableList[Author] = MutableList[Author]()
    try {
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

class Author(val id: Int, val name: String, val location: String) extends Comparable[Author] {

  override def compareTo(that: Author): Int = {
    val nameComp = this.name.toLowerCase compareTo that.name.toLowerCase
    if (nameComp != 0) nameComp
    else {
      val locationComp = this.location.toLowerCase compareTo that.location.toLowerCase
      if (locationComp != 0) locationComp
      else this.id compareTo that.id
    }
  }
  override def toString() = id + " " + name + " " + location

}

object Author {
  val orderingById: Ordering[Author] = Ordering.by(e => e.id)
  val orderingByName: Ordering[Author] = Ordering.by(e => e.name)
  val orderingByLocation: Ordering[Author] = Ordering.by(e => e.location)
  val orderingByNameThenLocationThanId: Ordering[Author] = Ordering.by(e => (e.location, e.name, e.id))
}





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
-----------------authorList.sorted-----------------------------------  
4 bharatha ayodhya
6 hanuma kishkinda
3 lakshman ayodhya
2 seeta midhila
5 shatrughna ayodhya
1 sriram ayodhya
7 sriram ayodhya
-----------------authorList.reverse----------------------------------  
4 bharatha ayodhya
3 lakshman ayodhya
2 seeta midhila
1 sriram ayodhya
7 sriram ayodhya
6 hanuma kishkinda
5 shatrughna ayodhya
-----------------sortWith------_.compareTo(_) < 0--------------------  
4 bharatha ayodhya
6 hanuma kishkinda
3 lakshman ayodhya
2 seeta midhila
5 shatrughna ayodhya
1 sriram ayodhya
7 sriram ayodhya
-----------------sortWith------_.compareTo(_) > 0--------------------  
7 sriram ayodhya
1 sriram ayodhya
5 shatrughna ayodhya
2 seeta midhila
3 lakshman ayodhya
6 hanuma kishkinda
4 bharatha ayodhya
-----------Author.Ordering.by(e => e.id)--------orderingById----------  
1 sriram ayodhya
2 seeta midhila
3 lakshman ayodhya
4 bharatha ayodhya
5 shatrughna ayodhya
6 hanuma kishkinda
7 sriram ayodhya
---------Author.Ordering.by(e => e.name)--------orderingByName--------  
4 bharatha ayodhya
6 hanuma kishkinda
3 lakshman ayodhya
2 seeta midhila
5 shatrughna ayodhya
7 sriram ayodhya
1 sriram ayodhya
-----Author.Ordering.by(e => e.location)--------orderingByLocation----  
5 shatrughna ayodhya
7 sriram ayodhya
1 sriram ayodhya
3 lakshman ayodhya
4 bharatha ayodhya
6 hanuma kishkinda
2 seeta midhila
-Author.Ordering.by(e => (e.location, e.name, e.id)-orderingByNameThenLocation- 
4 bharatha ayodhya
3 lakshman ayodhya
5 shatrughna ayodhya
1 sriram ayodhya
7 sriram ayodhya
6 hanuma kishkinda
2 seeta midhila
-----------------Ordering.by(e => e.id)--------orderingById------------  
1 sriram ayodhya
2 seeta midhila
3 lakshman ayodhya
4 bharatha ayodhya
5 shatrughna ayodhya
6 hanuma kishkinda
7 sriram ayodhya
----------------Ordering.by(e => e.name)--------orderingByName----------  
4 bharatha ayodhya
6 hanuma kishkinda
3 lakshman ayodhya
2 seeta midhila
5 shatrughna ayodhya
7 sriram ayodhya
1 sriram ayodhya
------------Ordering.by(e => e.location)--------orderingByLocation------  
5 shatrughna ayodhya
7 sriram ayodhya
1 sriram ayodhya
3 lakshman ayodhya
4 bharatha ayodhya
6 hanuma kishkinda
2 seeta midhila
--Ordering.by(e => (e.location, e.name, e.id)-orderingByNameThenLocation- 
4 bharatha ayodhya
3 lakshman ayodhya
5 shatrughna ayodhya
1 sriram ayodhya
7 sriram ayodhya
6 hanuma kishkinda
2 seeta midhila


*/
