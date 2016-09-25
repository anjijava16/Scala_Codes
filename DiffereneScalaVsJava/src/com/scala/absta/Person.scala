package com.scala.absta

class Person(val name:String,var lname:String,var age:Int) {
  
 override def toString="[Person:name="+name+" LastName="+lname+" age= "+age+"]";
/*  
  override  def toString = "[Person: firstName=" + firstName + " lastName=" + lastName +
    " age=" + age + "]"*/
 
 def doSoming={"Welcome to doSomething method here"};
}