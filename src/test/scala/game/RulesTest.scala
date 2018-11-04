package game

import exceptions.NothingLeftInDeckException
import model._
import org.scalatest.{FreeSpec, Matchers}

class RulesTest extends FreeSpec with Matchers {

  "Player actions Guard" - {
    "correctly guesses hand of another player" in {
      Rules.guardAction(guess = King, opponent = Player(holdingCard = King, pickedCard = None)) shouldBe true
    }

    "incorrectly guesses hand of another player" in {
      Rules.guardAction(guess = Baron, opponent = Player(holdingCard = King, pickedCard = None)) shouldBe false
    }
  }


}
