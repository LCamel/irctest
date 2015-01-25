package controllers

import irctest.LoginData
import irctest.Config
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text

object Login extends Controller {
  val loginForm = Form(
    mapping("password" -> text)(LoginData.apply)(LoginData.unapply)
  )

  def loginGet = Action { request =>
    Ok(views.html.login(loginForm))
  }
  def redirectToLoginGet = Action { implicit request =>
    TemporaryRedirect("/login") // TODO: reverse
  }


  def loginPost = Action { request =>
    println("==== Application loginPost: request: " + request)
    val loginData = loginForm.bindFromRequest()(request).get
    val authenticated = if (loginData.password == Config.loginPassword) { "true" } else { "false" }
    Redirect(routes.Application.index()).withSession("authenticated" -> authenticated)
  }
}