package game

import exceptions.NothingLeftInDeckException
import model._
import org.scalatest.{FreeSpec, Matchers}

class RulesTest extends FreeSpec with Matchers {

  "Player actions Guard" - {
    "correctly guesses hand of another player" in {
      Rules.guardAction(guess = King, opponent = Player(index = 1, holdingCard = King, pickedCard = None)) shouldBe true
    }

    "incorrectly guesses hand of another player" in {
      Rules.guardAction(guess = Baron, opponent = Player(index = 2, holdingCard = King, pickedCard = None)) shouldBe false
    }
  }

  "Player actions Priest" - {
    "knows the card of another player" in {
      val playerBeforeAction = Player(0, Priest, Some(Guard), Nil)
      val opponent = Player(1, Baron, None, Nil)

      val playerAfterAction = Rules.priestAction(playerBeforeAction, opponent)
      playerAfterAction.opponentsHands.size shouldBe 1
      playerAfterAction.opponentsHands(0).holdingCard shouldBe Baron
    }
  }


}
