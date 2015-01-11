import play.api.GlobalSettings

object Global extends GlobalSettings {
  println("==== init!")
  val nick = System.getenv("nick");
  println("env: nick: " + nick)
  
  /*
  val bot = new MyBot(nick)
  bot.setVerbose(true);
  bot.connect("chat.freenode.net")
  bot.joinChannel("#lcameltest")
  */
}