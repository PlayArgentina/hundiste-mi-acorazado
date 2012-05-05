package models

case class Board(tiles:List[List[Tile]]) {

  def shoot(x:Int, y:Int) ={
    val tile = tiles{x}{y}
    if (!tile.alreadyFired){
      tile.alreadyFired = true
      //si el tile tiene un ship, le pega, si no agua
      if (tile.ship!=Nil) tile.ship.hit
      else ShootResult.Missed
    }else{
      ShootResult.AlreadyFired
    }
    
  }
}
