package com.corescalaone

import scala.io.Source
import java.util.Comparator

trait Animal {
  def print(s: String): String
}

trait Mammal extends Animal {
  override def print(animal: String): String = { animal + " - Mammal" }
  def print(): String = { "mammalLocally" }
}

trait Reptile extends Animal {
  override def print(animal: String): String = { animal + " - Reptile" }
  def print(): String = { "reptileLocally" }
}

class MammalOrReptile extends Reptile with Mammal {
  override def print(): String = { "mammalOrReptile" }
}

class ReptileOrMammal extends Mammal with Reptile {
  override def print(): String = { "reptileOrMammal" }
}

class AnimalLocalMR extends Mammal with Reptile {
  def animalLocally() = print("AnimalLocalMR extends Mammal with Reptile")
  override def print(animalLocally: String): String = { super.print(); animalLocally }
  override def print(): String = { super.print() }
}

class AnimalLocalRM extends Reptile with Mammal {
  def animalLocally() = print("AnimalLocalRM extends Reptile with Mammal")
  override def print(animalLocally: String): String = { super.print(); animalLocally }
  override def print(): String = { super.print() }
}

object Inheritance {

  def main(args: Array[String]): Unit = {

    //multiple inheritance
    val mammal = new Mammal {}
    println(mammal.print("Elephant"));

    val reptile = new Reptile {}
    println(reptile.print("Turtle"));

    val mammalOrReptile = new MammalOrReptile
    println(mammalOrReptile.print("Elephant"))

    val reptileOrMammal = new ReptileOrMammal
    println(reptileOrMammal.print("Turtle"))

    var animalLocallyMR = new AnimalLocalMR with Reptile with Mammal
    println(animalLocallyMR.animalLocally)
    println(animalLocallyMR.print("Animal Locally MR"))
    println(animalLocallyMR.print())

    animalLocallyMR = new AnimalLocalMR
    println(animalLocallyMR.animalLocally)
    println(animalLocallyMR.print("Animal Locally MR"))
    println(animalLocallyMR.print())

    val animalLocallyRM = new AnimalLocalRM
    println(animalLocallyRM.animalLocally)
    println(animalLocallyRM.print("Animal Locally RM"))
    println(animalLocallyRM.print())

    // object reference as argument 
    val fooWithBar = new FooWithBar
    val fooBar = new FooBar with Foo with Bar
    fooWithBar.fooWithBar(fooBar)

    val loc = new LocationXY(10, 20, 15);
    loc.move(10, 10, 5);
  }
}

trait Foo { def foo(foo: String) }

trait Bar { def bar(bar: String) }

class FooBar extends Foo with Bar {
  override def foo(foo: String) { println("Hello, " + foo + "!") }
  override def bar(bar: String) { println("Hello, " + bar + "!") }
}

class FooWithBar {
  def fooWithBar(fooBar: FooBar with Foo with Bar) {
    fooBar.foo("foo")
    fooBar.bar("bar")
  }
}

protected class PointXY(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("Point x location : " + x);
    println("Point y location : " + y);
  }
}

class LocationXY(override val xc: Int, override val yc: Int,
                 val zc: Int) extends PointXY(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("Point x location : " + x);
    println("Point y location : " + y);
    println("Point z location : " + z);
  }
}

class AuthorOne(idl: Int, namel: String, locationl: String) {
  var id: Int = idl
  var name: String = namel
  var location: String = locationl
}



/*
OUTPUT
------

Elephant - Mammal
Turtle - Reptile
Elephant - Mammal
Turtle - Reptile
AnimalLocalMR extends Mammal with Reptile
Animal Locally MR
reptileLocally
AnimalLocalMR extends Mammal with Reptile
Animal Locally MR
reptileLocally
AnimalLocalRM extends Reptile with Mammal
Animal Locally RM
mammalLocally
Hello, foo!
Hello, bar!
Point x location : 20
Point y location : 30
Point z location : 20


*/


/**
 * NOTE :
 *Under the hood, there are other differences between functions and methods. Generally, a plain method generated less overhead than a function (which technically is an object with an apply method).
 *However, if you try not to care about those differences and think of def, val and var as fields with different semantics, then it’s simply that def evaluates every time it gets called while val evaluates only once.
 */