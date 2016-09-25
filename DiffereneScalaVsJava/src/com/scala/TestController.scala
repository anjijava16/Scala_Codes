package com.scala
class Foo(val age: Int, val name: String)
class Person(var name: String, var age: Int)
object TestController {
  def main(args: Array[String]): Unit = {
    //# use the class
    val al = new Person("Al", 42)
    al.name="199"; // "Al"
    al.age=19;
     
  }
}