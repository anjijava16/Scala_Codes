package com.corescalaone

object BasicTypesOperations {
  def main(args: Array[String]): Unit = {
    val xInt: Int = 12345;
    val xRInt: scala.runtime.RichInt = 12345;
    val xLong = 12345l;
    val xFloat = 1.2345678901234567;
    val xDouble = 1.2345678901234567;
    val xString = "12345"
    val xChar = 'x'
    val xFlag = true
    println(xInt)
    println(xLong)
    println(xFloat)
    println(xDouble)
    println(xString)
    println(xChar)
    println(xFlag)
    println(1 == 1.0)
    println(xRInt.underlying()) 
  }

}


/**
 * a "rich wrapper" that provides several additional methods.
	 Basic type Rich wrapper
      Byte 	scala.runtime.RichByte
      Short 	scala.runtime.RichShort
      Int 	scala.runtime.RichInt
      Char 	scala.runtime.RichChar
      Float 	scala.runtime.RichFloat
      Double 	scala.runtime.RichDouble
      Boolean 	scala.runtime.RichBoolean
      String 	scala.collection.immutable.StringOps
*/

/*

OUTPUT:
------

12345
12345
1.2345678901234567
1.2345678901234567
12345
x
true
true
12345

*/