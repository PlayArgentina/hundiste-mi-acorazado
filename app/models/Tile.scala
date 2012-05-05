package models

case class Tile( var id:String,   var alreadyFired:Boolean)  {
  var ship:Ship
}
