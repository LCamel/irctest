import org.jibble.pircbot.PircBot

class MyBot(val nick: String) extends PircBot {
  setName(nick)
}