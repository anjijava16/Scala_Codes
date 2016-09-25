package com.corescalaone

import scala.collection.mutable.MutableList
import java.io.IOException
import java.io.FileNotFoundException
import scala.io.Source
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader

import scala.util.control.Breaks._
import java.io._

object ForExpressionsExceptionHandling {
  def main(args: Array[String]): Unit = {
    val afile: java.io.FileReader = new FileReader(new File("src/resources/Authors.csv").getAbsolutePath())
    val source: BufferedReader = Source.fromURL(getClass.getResource("Authors.csv")).bufferedReader()
    partialFunctionOne(afile)
    partialFunctionSource(source)
  }

  def partialFunctionSource(source: BufferedReader) = {
    try {
      for (line <- Iterator.continually(source.readLine()).takeWhile(_ != null)) {
        println(line)
      }
    } catch {
      case e: IOException => e
      case _: Exception   => errorHandler(_)
    } finally {
      source.close()
    }
  }
  def partialFunctionOne(afile: FileReader) = {
    val input = new BufferedReader(afile)
    try {
      for (line <- Iterator.continually(input.readLine()).takeWhile(_ != null)) {
        println(line)
      }
    } catch {
      case e: IOException => e
      case _: Exception   => errorHandler(_)
    } finally {
      input.close()
      afile.close()
    }
  }
  def errorHandler(ex: Exception) {
    println("exception : " + ex)
  }
}
  
/*ExpressionsExceptionHandling

OUTPUT:
------
id,name,location
1,sriram,ayodhya
2,seeta,midhila
3,lakshman,ayodhya
4,bharatha,ayodhya
5,Shatrughna,ayodhya
6,hanuma,kishkinda
7,sriram,ayodhya

*/
