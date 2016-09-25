package com.scala.absta

object PersonMainObject extends Person( {
  
  def issue="{Issue shere }";
  
  def main(args: Array[String]): Unit = {
    
    
    var personObj=new Person("anji","MM",27);
    
    println(personObj.toString());
    println(personObj.name);
    println(personObj.lname);
    println(personObj.age);
    
    println(personObj.doSoming);
    
    println("Issues ::>>>>>>>>>>>>>>>>>>"+issue)
    
    
  }
}