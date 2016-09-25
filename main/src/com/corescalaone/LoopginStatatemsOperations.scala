/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2006-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package com.corescalaone

object LooppinStatatemsOperations {
  
  
  // ForLoop
  
  def testForLoopToOperation(){
    
    var id=0;
    for(id <- 1 to 6){ //1<=6
      println("Id valuees is "+id);
    }
  }
  
  
    def testForLoopUntilOperation(){
    
    var id=0;
    for(id <- 1 until 6){ //1<6 1,2,3,4,5
      println("Id valuees until is "+id);
    }
    
    }
    
    def testForLoopEachOperation(){
    /*
    var id=0;
    var newList=List(1,2,3,4,5,6,7);
    */
    var id="";
    var newList=List("jai","anji","MM","SSPR","Shena","KS","SRSP","ajkfkjad");
    try {
      
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }
    for(id <- newList){
        println("Id valuees Foreach is "+id);
    }
   
    }
    
  def main(args: Array[String]): Unit = {
    
    //testForLoopToOperation();
    
    // testForLoopUntilOperation();
    
    testForLoopEachOperation()
    
  }
}