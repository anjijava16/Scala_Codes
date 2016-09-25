package com.corescalaone

import scala.io.Source

object AnyDataTypesOperation {

  def nameReturnType(name: String): Any = {

    return name;
  }

  def intReturnType(name: String): Any = {
    var id: Int = 10;
    return id;
  }

  def floatReturnType(name: String): Any = {
    var id: Float = 10f;
    return id;
  }

  def main(args: Array[String]): Unit = {
    
    val html = Source.fromURL("http://google.com")
         val s = html.mkString
       println(s)
/*
    var xAny: Any = 10;
    print(xAny);
    */
    
    var xReturnAny:Any=intReturnType("Anji");
    
   /* var intConversion:Int=xReturnAny.##();
    println("RES"+intConversion);
   */ 
  }

}