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

  def guardAction(guess: Role, opponent: Player): Boolean = opponent.cards.holdingCard == guess

  def priestAction(player: Player, opponent: Player) = {
    player.copy(opponentsHands = opponent :: player.opponentsHands)
  }

  //returns the winning hand
  def baronAction(player: Player, opponent: Player): Player = {
    val cardToComparePlayer = player.cards.list.filterNot(_ == Baron).head

    if(points(cardToComparePlayer).compareTo(points(opponent.cards.holdingCard)) > 0) player
    else opponent

  }

}