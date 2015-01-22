import play.api.GlobalSettings
import play.api.Application
import irctest.MyAgent
import play.api.mvc.Handler
import play.api.mvc.RequestHeader
import play.api.Play
import play.api.Play.current
import play.api.mvc.Results.TemporaryRedirect

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
      // TODO: reverse
      if (request.path.startsWith("/assets/") || request.path.startsWith("/login")) {
        super.onRouteRequest(request)
      } else {
        request.session.get("authenticated") match {
          case Some("true") => super.onRouteRequest(request)
          case _            => Some(controllers.Login.redirectToLoginGet)
        }
      }
    }
  }

}
