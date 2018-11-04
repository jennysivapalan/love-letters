package model

case class Player(index: Int, cards: Cards, opponentsHands: List[Player] = Nil)

case class Cards(holdingCard: Role, pickedCard: Option[Role]) {
  def list: List[Role] = holdingCard :: pickedCard.toList

}


