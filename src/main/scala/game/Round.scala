package game

import exceptions.NothingLeftInDeckException
import model.{Deck, Player, Role}

import scala.util.Random

case class Round(deck: List[Role], players: List[Player])

object Round {

  def init(numPlayers: Int): Round = {
    val shuffledDeck = Deck.shuffle(Deck.init())
    val initialDeck = Deck.removeOne(shuffledDeck, Random.nextInt(shuffledDeck.size-1))
    val (cardsForPlayers, restOfDeck) = initialDeck.splitAt(numPlayers)

    val players = for(i <- 0 until numPlayers) yield {
      Player(index = i, holdingCard = cardsForPlayers(i), pickedCard = None, opponentsHands = Nil)
    }
    Round(restOfDeck, players.toList)
  }


  def takeFromTopOfDeck(deck: List[Role]): (Role, List[Role])  = {
    if(deck.isEmpty) throw new NothingLeftInDeckException("Round is probably over")
    else (deck.head, deck.tail)

  }

}

