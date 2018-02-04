package model

import org.scalatest.{FreeSpec, Matchers}


class DeckTest extends FreeSpec with Matchers {

  "Deck" - {
    "should have deck starting deck initialised" in {
      val deck = Deck.init()
      deck.size shouldEqual(16)
      val guards = deck.filter( p => p match { //easier way to do this?
        case Guard => true
        case _ => false
      })
      guards.size shouldEqual(5)

    }
  }
}
