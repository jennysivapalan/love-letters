package game

import model._

object Rules {

  def points(role: Role) = {
    role match {
      case Guard => 1
      case Prince => 5
      case _ => 0
    }
  }

  def guardAction(guess: Role, opponent: Player): Boolean = {
    if(guess == opponent.holdingCard) true
    else false
  }

  def priestAction(player: Player, opponent: Player) = {
    player.copy(opponentsHands = opponent :: player.opponentsHands)
  }

  //returns the winning hand
  def baronAction(player: Player, opponent: Player): Player = {
    val cardToComparePlayer =
      if(player.holdingCard == Baron) player.pickedCard.get
      else player.holdingCard

    if(points(cardToComparePlayer).compareTo(points(opponent.holdingCard)) > 0) player
    else opponent

  }

}