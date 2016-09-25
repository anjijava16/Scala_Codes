package com.corescalaone

class Point(xc: Int, yc: Int) {

  var x: Int = xc;
  var y: Int = yc;

  def move(dx: Int, dy: Int) {

    x = x + dx;
    y = y + dy;

    println("X Value is ::>>>" + x);
    println("Y Value is ::>>>" + y);
  }

}

object Demo {

  def main(args: Array[String]): Unit = {

    var callPoint = new Point(10, 20);
    println("Calling the move() method here ");
    callPoint.move(10, 20)
    println("Call toString() Method ::>>>>" + callPoint.toString());
    println(callPoint.hashCode());
  }
}