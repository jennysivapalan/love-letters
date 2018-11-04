package game

import exceptions.NothingLeftInDeckException
import model.{Guard, Handmaid, Player, Priest}
import org.scalatest.{FreeSpec, Matchers}

class RoundTest extends FreeSpec with Matchers {

  "Round" - {
    "should be set up correctly" in {
      val round = Round.init(2)
      round.deck.size shouldEqual 13
      round.players.size shouldEqual 2
    }

    "if no card in deck round ends" in {
        assertThrows[NothingLeftInDeckException]{
          Round.takeFromTopOfDeck(Nil)
        }
    }

    "if one card in deck player can take it" in {
      val (card, remaining) = Round.takeFromTopOfDeck(deck = List(Guard))
      card shouldEqual Guard
      remaining shouldEqual Nil
    }

    "if two cards in deck player can take top one" in {
      val (card, remaining) = Round.takeFromTopOfDeck(deck = List(Handmaid, Priest))
      card shouldEqual Handmaid
      remaining shouldEqual List(Priest)
    }

    //can remove?
    "if two players each can take from top of deck" in {
      val deck = List(Guard, Handmaid, Priest)
      val (player1Card, remaining)  = Round.takeFromTopOfDeck(deck = deck)
      player1Card shouldEqual Guard
      remaining shouldEqual List(Handmaid, Priest)
      val (player2Card, remaining2) = Round.takeFromTopOfDeck(remaining)
      player2Card shouldEqual Handmaid
      remaining2 shouldEqual List(Priest)

    }


  }


}
