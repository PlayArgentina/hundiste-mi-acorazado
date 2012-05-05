package controllers


import play.api._
import play.api.mvc._
import models.Board._
import models.{Game, Board, Tile}

object GameController extends Controller {
  
  def parse(username: String, shot : String) = TODO
  val game = Game

  def addPlayer(userName : String){
    if (game.player1 != Nil){
      game.player1 = userName
      return true
    }else if (game.player2 != Nil){
      game.player2 = userName
      return true
    }else{
      return false
    }

  }

}
