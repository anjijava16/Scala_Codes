package com.scala
case class Employee(name: String = "guest", age: Int = 30, company: String = "DevCode")
object MapReduce {
  def main(args: Array[String]): Unit = {

    val guest = Employee()
    val anna = Employee("Anna")
    val thomas = Employee("Thomas", 41)
    val luke = Employee("Luke", company = "LucasArt")
    val yoda = luke.copy("Yoda", age = 800)

    val allEmployees = List(luke, anna, guest, yoda, thomas)
    val sortedEmployees = allEmployees.groupBy(_.company)
    val averageAgeByCompany = sortedEmployees.map {
      case (key, value) =>
        value(0).copy(name = "average", age = (value.map(_.age).sum) / value.size)
    }
    println("Result: " + averageAgeByCompany)
  }
}