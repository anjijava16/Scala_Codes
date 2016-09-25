package com.inheritance

class Point(val xc: Int, val yc: Int) {

  var x: Int = xc;
  var y: Int = yc;

  def move(dx: Int, dy: Int) {
    x = x + dx;
    y = y + dy;
    println("X value is in Point(-,-)" + x);
    println("Y value is point(-,-)" + y);
  }
}

class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc;
  def move(dx: Int, dy: Int, dz: Int) {

    x = x + dx;
    y = y + dy;
    z = z + dz;

    println("X Value is " + x);
    println("Y Value is " + y);
    println("Z Value is " + z);

  }
}
object demo {

  def main(args: Array[String]): Unit = {

    var loc = new Location(10, 20, 30);

    loc.move(10, 20, 30)

  }
}