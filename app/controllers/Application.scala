package controllers

import play.api._
import play.api.mvc._

import play.api.Play.current

import actors.MyWebSocketActor

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def ws = WebSocket.acceptWithActor[String, String] { request => out =>
    MyWebSocketActor.props(out)
  }
}