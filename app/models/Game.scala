package models

import play.api.libs.iteratee.{PushEnumerator, Enumerator}


class Game {



  var members = Map.empty[String, PushEnumerator[String]]
  var player1: String = "";
  var player2: String = "";
  var board:Board(createBoard);

  def addPlayer(username: String , out : PushEnumerator[String]) = {

    members + (username -> out)

  }

  def calculateShot(s: String){


  }

  def notYourTurn(s: String){
    members{s}.push("not your turn motherfucker")
  }




}
