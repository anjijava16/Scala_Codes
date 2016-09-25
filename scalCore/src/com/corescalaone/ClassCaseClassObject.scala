package com.corescalaone

object ClassCaseClassObject {

  //The Application trait
  def main(args: Array[String]): Unit = {
    val checksumAccumulator: ChecksumAccumulator = new ChecksumAccumulator()
    checksumAccumulator.add(1)
    ChecksumAccumulator.add(checksumAccumulator, 1)
    ChecksumAccumulator.addObj(1)
    println("sum : " + checksumAccumulator.getSum)
    println("a : " + A.run)

    val classOne: ClassOne = new ClassOne(1, "ram", "ayodhya")
    println(classOne.getIdIns)
    val classTwo: ClassTwo = new ClassTwo(2, "seeta", "midhila")
    println(classTwo.id)
  }
}

object ClassObjectApp extends scala.App {

  val checksumAccumulator: ChecksumAccumulator = new ChecksumAccumulator()
  checksumAccumulator.add(1)
  ChecksumAccumulator.add(checksumAccumulator, 1)
  ChecksumAccumulator.addObj(1)
  println("sum : " + checksumAccumulator.getSum)
  println("a : " + A.run)
}

class ChecksumAccumulator {
  private var sum = 0

  def getSum: Int = sum
  def setSum_(sum: Int) { this.sum = sum }

  def add(b: Int) = { sum += b; }
}
//Singleton objects
//companion object.
//ChecksumAccumulator companion class
object ChecksumAccumulator extends ChecksumAccumulator {
  def addObj(b: Int) { (ChecksumAccumulator: ChecksumAccumulator).sum += b }
  def add(checksumAccumulator: ChecksumAccumulator, b: Int): Unit = { checksumAccumulator.sum += b }
}

/**
 * NOTE::
 * Private field in class cannot be accessed from companion object
 * def run { A.a = true } - value 'a' is not a member of object com.corescalaone.AObj
 */
class A {
  private var a: Boolean = false
}
object A extends A {
  def run = { (A: A).a = true; (A: A).a }
}

class ClassOne(id: Int, name: String, location: String) {
  private var idIns: Int = id
  def getIdIns(): Int = this.idIns
  def setIdIns_(idIns: Int): Unit = this.idIns = idIns
}
case class ClassTwo(id: Int, name: String, location: String)

/**
 * Scope of protection
 */
class SuperClass {
  private[corescalaone] var secretsOfCorescalaone: String = "secretsOfCorescalaone"
  protected[corescalaone] def scopeOfProtection() { println("scopeOfProtection") }
  private[this] var secrets: String = "this-secrets"
}
class SubClass extends SuperClass {
  scopeOfProtection()
  /**
   * val subClass : SubClass = new SubClass
   * subClass.secrets // value secrets is not a member of com.corescalaone.SubClass
   */

}
class Other {
  val superClass: SuperClass = new SuperClass
  superClass.scopeOfProtection() // Error: if fn is not accessible with out Scope of protection
  // superClass.secrets ERROR
}


/**
 * OUTPUT
 * sum : 2
 * a : true
 * 1
 * 2
 */
