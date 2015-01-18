package irctest

import com.typesafe.config.ConfigFactory
import scala.collection.JavaConverters._

object Config {
  private val config = ConfigFactory.load("irctest").getConfig("irctest")

  val server = config.getString("server")
  val channels = config.getStringList("channels").asScala
  val name = config.getString("name")

}

  /*
  def main(args: Array[String]) {
    // ./target/scala-2.11/classes/irctest.conf
    val config = ConfigFactory.load("irctest").getConfig("irctest")
    println("config: " + config)
    for (x <- config.getStringList("channels").asScala) {
      println("x: " + x)
    }
    println("hi2")
  }
  */

