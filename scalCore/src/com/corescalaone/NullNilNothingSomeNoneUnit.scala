package com.corescalaone

/**
 * Null– Its a Trait.
 * null– Its an instance of Null- Similar to Java null.
 * Nil– Represents an empty List of anything of zero length. Its not that it refers to nothing but it refers to List which has no contents.
 *
 * Nothing is a Trait. Its a subType of everything. But not superclass of anything. There are no instances of Nothing.
 *
 * None– Used to represent a sensible return value. Just to avoid null pointer exception. Option has exactly 2 subclasses- Some and None. None signifies no result from the method.
 *
 * Unit– Type of method that doesn’t return a value of any sort.
 *
 * Note: Any is superType of AnyRef and AnyVal. AnyRef is the superType of all the reference classes (like String, List, Iterable) in Scala. AnyVal is the superType of all the value classes (like: Int, Float, Double, Byte, Short..). Null is a subType of all the reference classes. null is its only instance. Nothing is subType of every other type i.e of reference and value classes.
 *
 * Think- AnyRef == Object in Java.
 *
 */
object NullNilNothingSomeNoneUnit {

  def main(args: Array[String]): Unit = {
    val someRef: String = null
    val nullRef: Null = null
    tryit(null)
    tryit(nullRef)
    // tryit(someRef) //- type mismatch; found : String required: Null
    var nilVal = Nil
    println(nilVal)
    var sdf = Nil + "a"
    println(sdf)
    println(nilVal + "a")
    var emptyStringListOne: List[String] = List[Nothing]()
    //val emptyStringListTwo: List[String] = List[Nothing]("abc") //- type mismatch; found : String("abc") required: Nothing
    emptyStringListOne.+:=("ram")
    println(emptyStringListOne)
    var emptyStringListTwo: List[String] = List("sriram")
    emptyStringListTwo.:+=("seeta")
    println(emptyStringListTwo)
    def printResult(num: Int): Any = {
      getAStringMaybe(num) match {
        case Some(res) => return res
        case None      => return "not a positive number!"
      }
    }
    println(printResult(10))
    println(printResult(-10))
    unitMe()

    //Option - Represents optional values. Instances of Option are either an instance of scala.Some or the object None.
    val greetingSome: Option[String] = Some("Hello world")
    println("greetingSome :: " + greetingSome)
    var greetingNone: Option[String] = None
    println(greetingNone)
    greetingNone = Option(null);

    UserRepository.findAllOption
    println(UserRepository.findByIdOption(3))
    //get
    val userRepositoryOption = UserRepository.findByIdOption(1)
    if (userRepositoryOption.isDefined) {
      println(userRepositoryOption.get.firstName)
    } else {
      println("println(userRepositoryOption.get.firstName)")
    }
    
    val userRepository = UserRepository.findById(1)
    println(userRepository.firstName)
  }

  def tryit(thing: Null): Unit = { println("That worked!"); }

  def getAStringMaybe(num: Int): Option[String] = {
    if (num >= 0) Some("a positive number!")
    else None // A number less than 0?  Impossible!
  }

  def unitMe(): Unit = {
    println("-unitMe-")
  }

}
case class User(
    id: Int,
    firstName: String,
    lastName: String,
    age: Int,
    gender: String) {
  override def toString = { id + " | " + firstName + " | " + lastName + " | " + age + " | " + gender }
}

//Option - Represents optional values. Instances of Option are either an instance of scala.Some or the object None.
case class UserOption(
    id: Int,
    firstName: String,
    lastName: String,
    age: Int,
    gender: Option[String]) {
  override def toString = { id + " | " + firstName + " | " + lastName + " | " + age + " | " + gender }
}

object UserRepository {
  private val userOption = Map(1 -> UserOption(1, "John", "Doe", 28, Some("male")), 2 -> UserOption(2, "merry", "roy", 27, Some("female")),
    3 -> UserOption(3, "Johanna", "merry", 27, None))
  def findByIdOption(id: Int): Option[UserOption] = userOption.get(id)
  def findAllOption = userOption.values.foreach { println }

  private val users = Map(1 -> User(1, "John", "Doe", 28, "male"), 2 -> User(2, "merry", "roy", 27, "female"))
  def findById(id: Int): User = users(1)
  def findAll = users.values.foreach { println }
}
