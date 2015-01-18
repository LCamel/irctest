package irctest

import scala.collection.mutable.Set

object MyAgent {
  val bot = new MyBot(Config.name)
  bot.setVerbose(true);

  trait Listener {
    def onMessage(message: String)
  }
  val listeners = Set[Listener]()
  def addListener(listener : Listener) { listeners += listener }
  def removeListener(listener: Listener) { listeners -= listener }

  def onStart() {
    bot.connect(Config.server)
    for (c <- Config.channels) {
      bot.joinChannel(c)
    }
  }
  def onStop() {
    bot.disconnect()
  }

  def send(message: String) {
    bot.sendMessage("#lcameltest", message)
  }

  def onMessage(channel: String, sender: String, login: String, hostname: String, message: String) {
    //println(s"channel: $channel sender: $sender login: $login hostname: $hostname message: $message")
    for (listener <- listeners) {
      listener.onMessage(message)
    }
  }

}