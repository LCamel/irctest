import play.api.GlobalSettings

object Global extends GlobalSettings {
  println("==== init!")
  println("env: a: " + System.getenv("a"))
}