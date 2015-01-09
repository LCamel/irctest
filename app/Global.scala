import play.api.GlobalSettings

object Global extends GlobalSettings {
  println("==== init!")
  println("env: a: " + System.getenv("a"))
  val bot = new MyBot
  bot.setVerbose(true);
  bot.connect("chat.freenode.net")
  bot.joinChannel("#lcameltest")
}