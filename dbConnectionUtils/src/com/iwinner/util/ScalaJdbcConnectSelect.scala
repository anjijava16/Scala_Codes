package com.iwinner.util

import java.sql.Connection
import java.sql.DriverManager

object ScalaJdbcConnectSelect extends DbConstatnsts{
  
  
  def getConnectionUtils():Connection={
     var connection: Connection = null;
     
    try {
      Class.forName(DRIVER);
     //connection=DriverManager.getConnection(DbConstatnsts., arg1, arg2) 
      
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }
     return connection;
  }
  
  def main(args: Array[String]): Unit = {
    
    println("DRIVER::>>>>"+DRIVER);
  }
  def maina(args: Array[String]) {
    println("DRIVER::>>>>"+DRIVER);
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/wsdb"
    val username = "root"
    val password = "root"

    // there's probably a better way to do this
    var connection: Connection = null;
    try {

      Class.forName(driver);

      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT host, user FROM users")
      while (resultSet.next()) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }

    } catch {
      case b: Throwable => b.printStackTrace();
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }
  }
}