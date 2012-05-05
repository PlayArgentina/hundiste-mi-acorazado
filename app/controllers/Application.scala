package controllers

import play.api._
import libs.iteratee.{Enumerator, Iteratee}
import libs.json.JsValue
import play.api.mvc._
import models.{Board}

object Application extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index())
  }

  def battleRoom(username: Option[String]) = Action { implicit request =>
    username.filterNot(_.isEmpty).map { username =>

    if(BoardManager.addPlayer(username)){
    Ok(views.html.battleRoom(username))
    }else{
      Redirect(routes.Application.index).flashing(
        "error" -> "Battle is full");
    }
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Please choose a valid username."
      )
    }
  }
  def shoot(username: String) = WebSocket.using[String] { request  =>

    val in =  Iteratee.foreach[String](s => GameController.parse(username,s))
    //pasar a shoot
    // Send a single 'Hello!' message and close
    val out = Enumerator("hello")

   // Board.join(username)
    (in, out)
  }
  
}