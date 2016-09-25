object Calculator {

  def fact(n: Integer) = {
    var i = n
    var a = 1
    while (i > 0) {
      a = a * i
      i -= 1
    }
    a
  }

  def tri(n: Integer) = {
    var res = 0
    for (i <- 1 to n) {
      res += i
    }
    res
  }

  def exp(n: Integer) = {
    var res = 2^n
    res
  }

  def isPrime(n: Integer) = {
    var res = true
    for (i <- 2 until n) {
      if (n % i == 0) { res = false }
    } 
    res
  }

  def main(args: Array[String]): Unit = {
    println("enter 3 integers x, y, and z on separate lines: ")
    var x = readInt()
    var y = readInt()
    var z = readInt()
    println("fact(x) = " + fact(x))
    println("fact(y) = " + fact(y))
    println("fact(z) = " + fact(z))
    println("tri(x) = " + tri(x))
    println("tri(y) = " + tri(y))
    println("tri(z) = " + tri(z))
    println("exp(x) = " + exp(x))
    println("exp(y) = " + exp(y))
    println("exp(z) = " + exp(z))
    println("isPrime(x) = " + isPrime(x))
    println("isPrime(y) = " + isPrime(y))
    println("isPrime(z) = " + isPrime(z))
  }

}