package game

import model.{Guard, Player, Prince, Role}

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
}