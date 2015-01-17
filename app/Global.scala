import play.api.GlobalSettings
import play.api.Application
import irctest.MyAgent

object Global extends GlobalSettings {
  println("==== Global init!")
  
  override def onStart(app: Application) {
    println("==== Global onStart()")
    MyAgent.onStart()
  }

  override def onStop(app: Application) {
    println("==== Global onStop()")
    MyAgent.onStop()
  }
}