package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import actors.MyWebSocketActor
import play.api.data._
import play.api.data.Forms._
import irctest.LoginData

object Application extends Controller {
  println("==== Application constructor")
  
  val loginForm = Form(
      mapping("password" -> text)(LoginData.apply)(LoginData.unapply)
  )

  def index = Action { request =>
    println("==== Application index")
    request.session.get("authenticated") match {
      case Some("true") => Ok(views.html.index("Your new application is ready."))
      case _ => Ok(views.html.login(loginForm))
    }
  }

  def ws = WebSocket.acceptWithActor[String, String] { request => out =>
    println("==== Application ws")
    MyWebSocketActor.props(out)
  }

  def loginPost = Action { request =>
    println("==== Application loginPost: request: " + request)
    val loginData = loginForm.bindFromRequest()(request).get
    val authenticated = if (loginData.password == "aaa") { "true" } else { "false" }
    Redirect(routes.Application.index()).withSession("authenticated" -> authenticated)
  }
}
