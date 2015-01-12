package irctest

import org.jibble.pircbot.PircBot

class MyBot(val nick: String) extends PircBot {
  setName(nick)

  override def onMessage(channel: String, sender: String, login: String, hostname: String, message: String) {
    //println(s"channel: $channel sender: $sender login: $login hostname: $hostname message: $message")
    MyAgent.onMessage(channel, sender, login, hostname, message)
  }
}