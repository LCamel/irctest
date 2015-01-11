import play.api.GlobalSettings
import play.api.Application

object Global extends GlobalSettings {
  println("==== init!")
  
  override def onStart(app: Application) {
    println("==== onStart()")
    MyAgent.onStart()
  }

  override def onStop(app: Application) {
    println("==== onStop()")
    MyAgent.onStop()
  }
}