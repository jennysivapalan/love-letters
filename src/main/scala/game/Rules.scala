package game

import exceptions.ActionNotPlayableOnHandmaid
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
    handmaidPlayed(opponent)
    opponent.cards.holdingCard == guess //TODO opponent should be out
  }

  def priestAction(player: Player, opponent: Player) = {
    handmaidPlayed(opponent)
    player.copy(opponentsHands = opponent :: player.opponentsHands)
  }

  //returns the winning hand
  def baronAction(player: Player, opponent: Player): Player = {
    handmaidPlayed(opponent)
    val cardToComparePlayer = player.cards.list.filterNot(_ == Baron).head

    if(points(cardToComparePlayer).compareTo(points(opponent.cards.holdingCard)) > 0) player
    else opponent
    //TODO loser should be out

  }

  def handmaidPlayed(opponent: Player) {
    if (opponent.cards.actioningHandmaid) throw ActionNotPlayableOnHandmaid("Cannot action guess this on player,")
  }

  def princeAction(opponent: Player, deck: List[Role]): Player = {
    handmaidPlayed(opponent)
    try {
      val newRole = Round.takeFromTopOfDeck(deck)
      val newCard = Cards(newRole._1, None)
      opponent.copy(cards = newCard)
    } catch {
      case e: NothingLeftInDeckException => throw PlayerIsOutOfRound(s"Player ${opponent.index} is out")
    }
  }


}