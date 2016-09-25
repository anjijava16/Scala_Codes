package com.corescalaone

import scala.collection.mutable.ListBuffer

object XMLTestOne extends App {

  import scala.xml._
  val bookElem = XML.loadFile("D:\\thanooj\\work\\Workspaces\\WSscala\\WSTwo\\Scalacore\\src\\resources\\book.xml")
  var bookAuthors: ListBuffer[BookAuthor] = new ListBuffer[BookAuthor]
  var bookAuthor: BookAuthor = null;
  var descriptions: ListBuffer[String] = null;
  var paperbacks: ListBuffer[String] = null;
  (bookElem \ "author").foreach { author =>
    bookAuthor = new BookAuthor();

    println("author : " + (author \ "@name").text + "\n")
    bookAuthor.name_=((author \ "@name").text)
    (author \ "publisher").foreach { publisher =>
      println(" publisher : " + (publisher \ "@name").text + "\n")
      bookAuthor.publisher_=((publisher \ "@name").text)
      (publisher \ "paperback").foreach { paperback =>
        paperbacks = ListBuffer[String]()
        paperbacks += ((paperback \ "@title").text)
        println("  paperback : " + (paperback \ "@title").text)
        (paperback \ "description").foreach { description =>
          descriptions = ListBuffer[String]()
          descriptions += ((description \ "@link").text)
          println("  description : " + (description \ "@link").text)
        }
        bookAuthor.description ++= (descriptions)
      }
      bookAuthor.paperback ++= (paperbacks)
    }
    bookAuthors :+= bookAuthor
  }
  println("---------------------------------------toString---------------------------------------------------")
  for (author <- bookAuthors) println(author)
}

class BookAuthor {
  var _name: String = null
  var _publisher: String = null
  var _paperback: ListBuffer[String] = new ListBuffer[String]()
  var _description: ListBuffer[String] = new ListBuffer[String]()

  def name_=(_name: String) = this._name = _name
  def name = this._name
  def publisher_=(_publisher: String) = this._publisher = _publisher
  def publisher = this._publisher
  def paperback_=(_paperback: ListBuffer[String]) = this._paperback ++= _paperback
  def paperback = this._paperback
  def description_=(_description: ListBuffer[String]) = this._description ++= _description
  def description = this._description

  override def toString() = _name + " | " + _publisher + " | " + _paperback + " | " + _description
}


/*
 Note : add 'scala-xml-2.11.0-M4.jar'

OUTPUT:
-------

author : Kathy Sierra

 publisher : Head First labs

  paperback : Head First Java, Second Edition
  description : http://www.headfirstlabs.com/books/hfjava/
  paperback : Head First EJB
  description : http://www.headfirstlabs.com/books/hfejb/
  paperback : Head First C#, 3rd Edition
  description : http://shop.oreilly.com/product/0636920027812.do
  paperback : Head First Design Patterns
  description : http://www.headfirstlabs.com/books/hfdp/
author : Kathy Sierra Two

 publisher : Head First labs Two

  paperback : Head First Java, Second Edition Two
  description : http://www.headfirstlabs.com/books/hfjava/ Two
  paperback : Head First EJB Two
  description : http://www.headfirstlabs.com/books/hfejb/ Two
  paperback : Head First C#, 3rd Edition Two
  description : http://shop.oreilly.com/product/0636920027812.do Two
  paperback : Head First Design Patterns Two
  description : http://www.headfirstlabs.com/books/hfdp/ Two
---------------------------------------toString---------------------------------------------------
Kathy Sierra | Head First labs | ListBuffer(Head First Design Patterns) | ListBuffer(http://www.headfirstlabs.com/books/hfjava/, http://www.headfirstlabs.com/books/hfejb/, http://shop.oreilly.com/product/0636920027812.do, http://www.headfirstlabs.com/books/hfdp/)
Kathy Sierra Two | Head First labs Two | ListBuffer(Head First Design Patterns Two) | ListBuffer(http://www.headfirstlabs.com/books/hfjava/ Two, http://www.headfirstlabs.com/books/hfejb/ Two, http://shop.oreilly.com/product/0636920027812.do Two, http://www.headfirstlabs.com/books/hfdp/ Two)


*/