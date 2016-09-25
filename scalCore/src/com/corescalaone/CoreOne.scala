/**
 * http://booksites.artima.com/programming_in_scala_2ed/examples/index.html
 * https://twitter.github.io/scala_school/
 * https://dzone.com/articles/revealing-scala-magician%E2%80%99s
 *
 * Why Scala?
 * Expressive
 * First-class functions
 * Closures
 * Concise
 * Type inference
 * Literal syntax for function creation
 * Java interoperability
 * Can reuse java libraries
 * Can reuse java tools
 * No performance penalty
 *
 *
 *
 * How Scala?
 * Compiles to java bytecode
 * Works with any standard JVM
 * Or even some non-standard JVMs like Dalvik
 * Scala compiler written by author of Java compiler
 *
 *
 */
package com.corescalaone

import scala.collection.mutable.ListBuffer

object CoreOne {
  def main(args: Array[String]): Unit = {
    println("CoreOne!")

    val itoInt: Int = "123".toInt
    println(itoInt)

    val colors = List("blue", "yellow", "red")
    val colorsToArray = colors.toArray
    println(colorsToArray.length)
    colorsToArray.foreach(println(_))

    val range10To20By3 = 10.to(20).by(3)
    println(range10To20By3)
    // Use toList to convert a range to a list.
    val list10To20By3 = range10To20By3.toList
    println(list10To20By3)

    val ptOne = new Point(1, 2)
    println(ptOne)
    ptOne.move(10, 10)
    println(ptOne)

    val ptTwo = new Point(1)
    println(ptTwo)
    ptTwo.move(10, 10)
    println(ptTwo)

    val ptThree = new Point()
    println(ptThree)
    ptThree.move(10, 10)
    println(ptThree)

    // List - scala.collection.immutable.List
    listOperations()

    //Set - scala.collection.immutable.Set
    setOperations()

    // Map - collection.mutable.Map
    mapOperations()

    val vectorOne = for (i <- 1 to 5) yield i
    println(vectorOne)
    val vectorTwo = for (e <- vectorOne) yield e
    println(vectorTwo)

    def adder(m: Int, n: Int) = m + n
    println(adder(10, 20))
    //Partial application
    val addPartial = adder(2, _: Int)
    println(addPartial(20))

  }

  /**
   * Map
   */
  def mapOperations() {
    var cacheValOne = Map[String, Int]()
    cacheValOne += ("x" -> 10, "y" -> 11)
    cacheValOne += ("z" -> 12)
    cacheValOne ++ (cacheValOne)
    println(cacheValOne get "x")
    println(cacheValOne("x") + " | " + cacheValOne.get("x"))

    println(cacheValOne)
    cacheValOne.updated("x", 1)
    println(cacheValOne)
    println(cacheValOne.empty)
  }

  /**
   * Set
   */
  def setOperations() {
    /**
     * scala> var s = Set(1, 2, 3)
     * s: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
     * scala> s += 4
     * scala> s -= 2
     * scala> s
     * res2: scala.collection.immutable.Set[Int] = Set(1, 3, 4)
     *
     * scala> val s = collection.mutable.Set(1, 2, 3)
     * s: scala.collection.mutable.Set[Int] = Set(1, 2, 3)
     * scala> s += 4
     * res3: s.type = Set(1, 4, 2, 3)
     * scala> s -= 2
     * res4: s.type = Set(1, 4, 3)
     */
    var fruitSetOne = Set("apple", "orange", "peach", "apple")
    println("in fruitSetOne 'peach' found : " + fruitSetOne("peach"))
    fruitSetOne += ("banana")
    println(fruitSetOne)
    println("in fruitSetOne 'banana' found : " + fruitSetOne("banana"))
  }

  /**
   * List
   */
  def listOperations() {

    val list = List("1", "2", "3")

    for (i <- 0 until list.length) {
      println(i + "th element is: " + list(i));
    }

    for (strInt <- list) {
      println(strInt);
    }

    def listOne = list.flatMap(o => o)
    println("listOne :" + listOne)

    val xOne = List(1, 2, 3, 4)
    println(xOne)
    println(List[Number](1, 2.0, 33d, 0x1))
    println(List.range(1, 10))
    println(List.range(0, 10, 2))
    println(0 :: List[Number](1, 2.0, 33d, 0x1))
    println(List.concat(xOne, xOne))

    xOne.foreach { println }

    var sumOne = 0
    xOne.foreach(sumOne += _)
    println("sumOne : " + sumOne)

    var namesOne = List("Bob", "Fred", "Joe", "Julia", "Kim")
    namesOne.:+=("-ram-") // appand last
    namesOne ++= namesOne
    namesOne.+:=("-seeta-") // append first 
    for (name <- namesOne) println(name)
    namesOne.foreach { println }

    for (name <- namesOne if name.startsWith("J"))
      println("names starting with J" + name)

    val xOneEvens = xOne.filter(a => a % 2 == 0)
    println("xOneEvens : " + xOneEvens)

    println("_ < 6 : " + xOne.takeWhile(_ < 6))
    println("_ * 2 : " + xOne.map(_ * 2))
    println("a => a * 2 : " + xOne.map(a => a * 2))
    println("_.toLowerCase : " + namesOne.map(_.toLowerCase))
    println("_.toUpperCase : " + namesOne.map(_.toUpperCase()))
    println("xOne.sorted : " + xOne.sorted);
    println("sortWith(_.compareTo(_)) : " + xOne.sortWith(_.compareTo(_) > 0));

    /**
     * partition - returns a pair of lists, one where the predicate is true, the other where the predicate is false
     * find      - returns the first element matching a predicate (as opposed to returning all such elements)
     * Others:   takeWhile, dropWhile, span
     *
     * length  - returns the length of a List
     * head    - returns the first element of a List
     * last    - returns the last element of a List
     * init    - returns a List consisting of all elements except the last one
     * tail    - returns every elements of a List except the first element
     * isEmpty - returns a Boolean indicating if the List is empty
     *
     * reverse - returns a reversed version of the List
     * flatten - takes a list of lists and flattens it out to a single list
     *
     * mkString - converts a List to a String
     *
     * iterator
     * toArray
     *
     * foldLeft
     * reduceLeft
     *
     * map
     * flatMap
     * foreach
     *
     * forall
     * exists
     *
     * Folding lists: /: and :\
     *
     * sortWith
     */

    /*
     * http://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes
     * http://stackoverflow.com/questions/14058711/vector-or-mutablelist-listbuffer-for-performance
     * 
     * List - scala.collection.mutable.ListBuffer
     * ListBuffer uses internally Nil and :: to build an immutable List and allows constant-time removal of the first and last elements.
     * To do so, it keeps a pointer on the first and last element of the list, and is actually allowed to change the head and tail 
     */
    var yOne = ListBuffer[Int](2)
    yOne.+=(1)
    yOne.+=(2)
    yOne += (3)
    yOne = 4 +: yOne
    yOne.++=(yOne)
    println("yOne : " + yOne :: (yOne :: Nil))
    println("yOne.length : " + yOne.length + " | yOne.apply(4) : " + yOne.apply(4))

    // List of String
    val fruitListOne: List[String] = List("apples", "oranges", "pears")
    // List of Integer
    val numList: List[Int] = List(1, 2, 3, 4)
    // Empty List.
    val emptyList: List[Nothing] = List()

    /* Note: All lists can be defined using two fundamental building blocks, a tail Nil and :: (cons). Nil also represents the empty list.
     */
    var fruitListTwo = "apples" :: ("oranges" :: ("pears" :: Nil))

    println(fruitListOne)
    println("Head of fruitListTwo : " + fruitListTwo.head)
    println("Tail of fruitListTwo : " + fruitListTwo.tail)
    println("Tail of fruitListTwo.take : " + fruitListTwo.take(2))
    println("Tail of fruitListTwo.drop : " + fruitListTwo.drop(2))
    println("Tail of fruitListTwo.flatMap : " + emptyList.flatMap { x => fruitListTwo })
    println("Check if fruitListTwo is empty : " + fruitListTwo.isEmpty)
    println("Check if emptyList is empty : " + emptyList.isEmpty)
  }
}

class Point(xc: Int, yc: Int) {

  var x: Int = xc
  var y: Int = yc

  def this(xc: Int) {
    this(xc, 0)

  }
  def this() {
    this(0, 0)
  }

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = "(" + x + ", " + y + ")";
}

/**
 * Singleton Object -
 * Methods and values that aren’t associated with individual instances of a class belong in singleton objects, denoted by using the keyword object instead of class.
 * This sum method is available globally, and can be referred to, or imported, as com.corescalaone.SumOfList.
 */
object SumOfList {
  def sum(list: List[Int]): Int = list.sum
}



/*

OUTPUT:
------

CoreOne!
123
3
blue
yellow
red
Range(10, 13, 16, 19)
List(10, 13, 16, 19)
(1, 2)
(11, 12)
(1, 0)
(11, 10)
(0, 0)
(10, 10)
0th element is: 1
1th element is: 2
2th element is: 3
1
2
3
listOne :List(1, 2, 3)
List(1, 2, 3, 4)
List(1, 2.0, 33.0, 1)
List(1, 2, 3, 4, 5, 6, 7, 8, 9)
List(0, 2, 4, 6, 8)
List(0, 1, 2.0, 33.0, 1)
List(1, 2, 3, 4, 1, 2, 3, 4)
1
2
3
4
sumOne : 10
-seeta-
Bob
Fred
Joe
Julia
Kim
-ram-
Bob
Fred
Joe
Julia
Kim
-ram-
-seeta-
Bob
Fred
Joe
Julia
Kim
-ram-
Bob
Fred
Joe
Julia
Kim
-ram-
names starting with JJoe
names starting with JJulia
names starting with JJoe
names starting with JJulia
xOneEvens : List(2, 4)
_ < 6 : List(1, 2, 3, 4)
_ * 2 : List(2, 4, 6, 8)
a => a * 2 : List(2, 4, 6, 8)
_.toLowerCase : List(-seeta-, bob, fred, joe, julia, kim, -ram-, bob, fred, joe, julia, kim, -ram-)
_.toUpperCase : List(-SEETA-, BOB, FRED, JOE, JULIA, KIM, -RAM-, BOB, FRED, JOE, JULIA, KIM, -RAM-)
xOne.sorted : List(1, 2, 3, 4)
sortWith(_.compareTo(_)) : List(4, 3, 2, 1)
List(yOne : ListBuffer(4, 2, 1, 2, 3, 4, 2, 1, 2, 3), ListBuffer(4, 2, 1, 2, 3, 4, 2, 1, 2, 3))
yOne.length : 10 | yOne.apply(4) : 3
List(apples, oranges, pears)
Head of fruitListTwo : apples
Tail of fruitListTwo : List(oranges, pears)
Tail of fruitListTwo.take : List(apples, oranges)
Tail of fruitListTwo.drop : List(pears)
Tail of fruitListTwo.flatMap : List()
Check if fruitListTwo is empty : false
Check if emptyList is empty : true
in fruitSetOne 'peach' found : true
Set(apple, orange, peach, banana)
in fruitSetOne 'banana' found : true
Some(10)
10 | Some(10)
Map(x -> 10, y -> 11, z -> 12)
Map(x -> 10, y -> 11, z -> 12)
Map()
Vector(1, 2, 3, 4, 5)
Vector(1, 2, 3, 4, 5)
30
22


*/

/**
 * Note:
 * Scala first-order and higher-order functions:
 * A Scala method is first-order if it does not take any functions as arguments.
 * Higher-order functions are functions that take other functions as parameters.
*/