import play.api.GlobalSettings
import play.api.Application
import irctest.MyAgent
import play.api.mvc.Handler
import play.api.mvc.RequestHeader
import play.api.Play
import play.api.Play.current

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


  // http://stackoverflow.com/questions/19147147/best-way-to-force-playframework-2-to-always-use-ssl
  // https://www.playframework.com/documentation/2.3.x/Production
  override def onRouteRequest(request: RequestHeader): Option[Handler] = {
    if (Play.isProd && !request.headers.get("x-forwarded-proto").getOrElse("").contains("https")) {
      Some(controllers.Secure.redirect)
    } else {
      super.onRouteRequest(request)
    }
  }

}
