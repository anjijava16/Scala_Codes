package com.corescalaone

//object TraitOne (a : Int) - traits or objects may not have parameters
object TraitOne {
  def main(args: Array[String]): Unit = {

    val starCruiser = new StarCruiser(100, 0)
    println(starCruiser.engage)
    println(starCruiser.speedUp)
  }
}
//traits or objects may not have parameters
trait Spacecraft {
  def engage(): String
}

trait CommandoBridge extends Spacecraft {
  def engage(): String = {
    println("inside engage")
    for (_ <- 1 to 3) {
      println("inside loop engage")
      speedUp()
    }
    return "engage loop for 3 times"
  }
  def speedUp(): Int
}

trait PulseEngine extends CommandoBridge {
  val maxPulse: Int
  var currentPulse: Int
  def speedUp(): Int = {
    println("inside speedUp " + maxPulse)
    if (currentPulse < maxPulse) {
      println("inside if speedUp")
      currentPulse += 1
    }
    currentPulse
  }
}

class StarCruiser(mp: Int, cp: Int) extends PulseEngine {
  val maxPulse = mp
  var currentPulse = cp
}


/*

OUTPUT:
------
inside engage
inside loop engage
inside speedUp 100
inside if speedUp
inside loop engage
inside speedUp 100
inside if speedUp
inside loop engage
inside speedUp 100
inside if speedUp
engage loop for 3 times
inside speedUp 100
inside if speedUp
4

*/