package irctest

object MyAgent {
  val nick = System.getenv("nick");
  val bot = new MyBot(nick)
  bot.setVerbose(true);

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
}