package irctest

import scala.collection.mutable.Set

object MyAgent {
  val nick = System.getenv("nick");
  val bot = new MyBot(nick)
  bot.setVerbose(true);

  trait Listener {
    def onMessage(message: String)
  }
  val listeners = Set[Listener]()
  def addListener(listener : Listener) { listeners += listener }
  def removeListener(listener: Listener) { listeners -= listener }

  def onStart() {
    bot.connect("chat.freenode.net")
    bot.joinChannel("#lcameltest")
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