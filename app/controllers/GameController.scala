package controllers


import play.api._
import libs.iteratee.PushEnumerator
import libs.json.JsValue
import play.api.mvc._
import models.Board._
import models.{Game, Board, Tile}

object GameController extends Controller {


  val game = new Game
  var currentPlayer = "";
  //def parse(username: String, shot : String) = TODO
  def parse(username: String, shot: String) {
    if (username.equals(currentPlayer)){
      game.calculateShot(username);
    }else{
      game.notYourTurn(username);
    }



  }

  def addPlayer(s: String,out : PushEnumerator[String]){
     game.addPlayer(s,out)
  }


  def addPlayer(userName : String){
    if (game.player1 != Nil){
      game.player1 = userName
      true
    }else if (game.player2 != Nil){
      game.player2 = userName
      currentPlayer = game.player2
      true
    }else{
      false
    }

  }



}
