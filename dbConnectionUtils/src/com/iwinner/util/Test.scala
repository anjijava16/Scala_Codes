package com.iwinner.util

object Test {
  def main(args: Array[String]): Unit = {

    def even: Int => Boolean = _ % 2 == 0
    even eq even
    println(even)
  }
}