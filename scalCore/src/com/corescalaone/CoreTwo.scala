/**
 * 1. Create an array of random numbers and print them it in a sorted order
 *
 * 2. Print list of even numbers and odd numbers from an array
 *
 * 3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield
 *
 * 4. Function that returns a tuple of minimum and maximum values of an array
 *
 * 5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map
 *
 * 6. Create a class called Connection( connectionId, url, port). How will you ensure that you will not create more than 10 connection objects?
 *
 * 7. Print the list of files in a directory using cmd/shell
 */
package com.corescalaone

import scala.util.Random
import scala.collection.mutable.ListBuffer

object CoreTwo {
  def main(args: Array[String]): Unit = {

    /**
     * 1. Create an array of random numbers and print them it in a sorted order
     */
    println("1. Create an array of random numbers and print them it in a sorted order");
    //1
    var array = Seq.fill(5)(Random.nextInt(10))
    array.foreach { println }
    array = array.sorted
    array.foreach { println }
    //2
    var randomArray = for (i <- -1 to 5 if ((i != -1))) yield if (i != 3) { Random.nextInt(100) } else 0
    randomArray = randomArray.sorted

    randomArray.foreach { println }
    //3
    var arr = new Array[Int](5)
    for (i <- 0 to arr.length - 1) {
      arr(i) = (Random.nextInt(100))
    }
    arr = arr.sorted
    arr.foreach { println }

    /**
     * 2. Print list of even numbers and odd numbers from an array
     */
    println("2. Print list of even numbers and odd numbers from an array")
    var arr2 = new Array[Int](5)
    var evenListOne = Array[Int]()
    var oddListOne = Array[Int]()

    for (i <- 0 until arr2.length) arr2(i) = (Random.nextInt(100))
    arr2 = arr2.sorted
    val nums = arr2.partition(x => x % 2 == 0)
    val evenNums = nums._1
    val oldNum = nums._2
    println("evenNums : " + evenNums.toList)
    println("oldNum : " + oldNum.toList)

    println(arr2.foreach { println })
    for (i <- 0 to arr2.length - 1) {
      if (arr2(i) % 2 == 0) evenListOne.:+=(arr2(i)) else oddListOne.:+=(arr2(i))
    }
    println(evenListOne.foreach { println })
    println(oddListOne.foreach { println })

    /**
     * 3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield
     */
    println("3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield")
    arr.foreach { println }
    println("swaps adjacent pairs of elements in an array: ")
    //1
    arr.grouped(2)
      .flatMap {
        case Array(x, y) => Array(y, x)
        case Array(x)    => Array(x)
      }.toArray.foreach { println }
    //2
    (for { b <- arr.grouped(2); c <- b.reverse } yield c).toArray.foreach { println }

    /**
     * 4. Function that returns a tuple of minimum and maximum values of an array
     */
    println("4. Function that returns a tuple of minimum and maximum values of an array")
    val minMaxTuple = new Tuple2(arr2(0), arr2(arr2.length - 1))
    println("minMaxTuple : " + minMaxTuple)
    println("MIN : " + minMaxTuple._1 + " | " + "MAX : " + minMaxTuple._2)

    /**
     * 5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map
     */
    println("5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map")
    val aInt = Array[Int](1, 2, 3, 4)
    val bStr = Array[String]("a", "b", "c", "d")
    var finalTupleOfab = List[Tuple2[Int, String]]()
    for (i <- 0 to bStr.length - 1) {
      var tupleOfab = new Tuple2[Int, String](aInt(i), bStr(i))
      finalTupleOfab.:+=(tupleOfab)
    }
    println(finalTupleOfab)
    println(finalTupleOfab.toMap)

    //Class and Companions
    println("6. Create a class called Connection( connectionId, url, port). How will you ensure that you will not create more than 10 connection objects?");
    Connection.connCount = 2
    Connection(1, "google.com", 25)
    Connection(2, "yahoo.com", 26)
    Connection(3, "goibibo.com", 27)
    Connection(4, "impetus", 28)
    println(Connection.conns.length)
    Connection.conns.foreach { println }
    Connection.conns.clear()
    println(Connection.conns.length)
  }

  /**
   * 6. Create a class called Connection( connectionId, url, port). How will you ensure that you will not create more than 10 connection objects?
   */
  class Connection(connectionId: Int, url: String, port: Long) {
    override def toString = connectionId + ", " + url + ", " + port + " - " + this.hashCode
  }
  object Connection {
    var connCount: Int = 0
    var conns = new ListBuffer[Connection]

    def apply(connectionId: Int, url: String, port: Long): Connection = {
      var connection: Connection = null
      if (conns.size < connCount) {
        connection = new Connection(connectionId, url, port)
        conns.:+=(connection)
      }
      connection
    }
  }

  //println("7. Print the list of files in a directory using cmd/shell")

  /**
   * I have used shell commands in Linux with scala
   *
   *
   * scala> import sys.process._
   * import sys.process._
   *
   * scala> val cmd = stringToProcess("ls")
   * cmd: scala.sys.process.ProcessBuilder = [ls]
   *
   * scala> val status = cmd.!
   * derby.log
   * Desktop
   * Documents
   * Downloads
   * examples.desktop
   * home
   * status: Int = 0
   *
   * scala> val ls = "ls".!
   * derby.log
   * Desktop
   * Documents
   * Downloads
   * examples.desktop
   * home
   * ls: Int = 0
   *
   * scala> Process("ls", Seq("-oa")).!
   * total 1164
   * drwxr-xr-x 24 ubuntu   4096 Feb 18 23:17 .
   * drwxr-xr-x  3 root     4096 Jul 31  2015 ..
   * -rw-r--r--  1 ubuntu   5039 Feb 18 23:16 .bashrc
   * -rw-r--r--  1 ubuntu   5039 Feb 18 23:16 .bashrc~
   * drwx------ 19 ubuntu   4096 Feb  7 23:16 .cache
   * drwx------ 18 ubuntu   4096 Feb  8 02:34 .config
   * drwx------  3 ubuntu   4096 Feb 15 01:11 .dbus
   * -rw-rw-r--  1 ubuntu  21070 Feb 15 02:30 derby.log
   * drwxr-xr-x  4 ubuntu   4096 Feb 15 02:32 Desktop
   * -rw-r--r--  1 ubuntu     25 Jul 31  2015 .dmrc
   * drwxr-xr-x  2 ubuntu   4096 Jul 31  2015 Documents
   * drwxr-xr-x  6 ubuntu   4096 Feb  8 01:06 Downloads
   * drwx------  3 ubuntu   4096 Feb 18 23:12 .gconf
   * drwxrwxr-x  3 ubuntu   4096 Feb  8 03:58 home
   * res0: Int = 0
   *
   *
   * scala>
   *
   * scala> val lsOfLs = "ls".!!
   * lsOfLs: String =
   * "derby.log
   * Desktop
   * Documents
   * Downloads
   * examples.desktop
   * home
   * "
   *
   * scala> lsOfLs
   * res1: String =
   * "derby.log
   * Desktop
   * Documents
   * Downloads
   * examples.desktop
   * home
   * "
   *
   *
   *
   *
   * NOTE: http://rosettacode.org/wiki/Execute_a_system_command#Scala
   */

  
  
  /*

OUTPUT:
------
1. Create an array of random numbers and print them it in a sorted order
4
8
5
2
0
0
2
4
5
8
0
12
35
46
68
96
13
51
52
63
97
2. Print list of even numbers and odd numbers from an array
evenNums : List(18)
oldNum : List(21, 51, 79, 91)
18
21
51
79
91
()
18
()
21
51
79
91
()
3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield
13
51
52
63
97
swaps adjacent pairs of elements in an array: 
51
13
63
52
97
51
13
63
52
97
4. Function that returns a tuple of minimum and maximum values of an array
minMaxTuple : (18,91)
MIN : 18 | MAX : 91
5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map
List((1,a), (2,b), (3,c), (4,d))
Map(1 -> a, 2 -> b, 3 -> c, 4 -> d)
6. Create a class called Connection( connectionId, url, port). How will you ensure that you will not create more than 10 connection objects?
2
1, google.com, 25 - 356573597
2, yahoo.com, 26 - 1735600054
0




*/
}