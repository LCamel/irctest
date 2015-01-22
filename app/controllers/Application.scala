package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import actors.MyWebSocketActor
import play.api.data._

import irctest.LoginData

object Application extends Controller {
  println("==== Application constructor")

  def index = Action { request =>
    println("==== Application index")
    Ok(views.html.index("Your new application is ready."))
  }

  def ws = WebSocket.acceptWithActor[String, String] { request => out =>
    println("==== Application ws")
    MyWebSocketActor.props(out)
  }

}
