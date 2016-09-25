package com.scala.pojo

class Person(val firstName: String, val lastName: String, val age: Int) {
override  def toString = "[Person: firstName=" + firstName + " lastName=" + lastName +
    " age=" + age + "]"
}