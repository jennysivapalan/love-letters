package game

import exceptions.NothingLeftInDeckException
import model._
import org.scalatest.{FreeSpec, Matchers}

class RulesTest extends FreeSpec with Matchers {

  "Player actions Guard" - {
    "correctly guesses hand of another player" in {
      val opponent = Player(index = 1, cards = Cards(holdingCard = King, pickedCard = None), opponentsHands = Nil)
      Rules.guardAction(guess = King, opponent = opponent) shouldBe true
    }

    "incorrectly guesses hand of another player" in {
      val opponent = Player(index = 1, cards = Cards(holdingCard = King, pickedCard = None), opponentsHands = Nil)

      Rules.guardAction(guess = Baron, opponent = opponent) shouldBe false
    }
  }

  "Player actions Priest" - {
    "knows the card of another player" in {
      val playerBeforeAction = Player(0, Cards(Priest, Some(Guard)), Nil)
      val opponent = Player(1, Cards(Baron, None), Nil)

      val playerAfterAction = Rules.priestAction(playerBeforeAction, opponent)
      playerAfterAction.opponentsHands.size shouldBe 1
      playerAfterAction.opponentsHands(0).cards.holdingCard shouldBe Baron
    }
  }

  "Player actions Baron" - {
    "hand with higher points should win" in {
      val player = Player(1, Cards(Baron, Some(Handmaid)), Nil)
      val opponent = Player(2, Cards(King, None), Nil)
      Rules.baronAction(player, opponent) shouldBe opponent
    }
  }


}
