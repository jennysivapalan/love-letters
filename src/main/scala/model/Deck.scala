package model

import scala.util.Random

object Deck {
  def init(): List[Role] = {

    List.fill(5)(Guard) ++
    List.fill(2)(Priest) ++
    List.fill(2)(Baron) ++
    List.fill(2)(Handmaid) ++
    List.fill(2)(Prince) ++
    List.fill(1)(King) ++
    List.fill(1)(Countess) ++
    List.fill(1)(Princess)
  }

  def shuffle(deck: List[Role]) = Random.shuffle(deck)

  def removeOne(deck: List[Role], index: Int) = {
    deck.patch(index, Nil, 1)
  }
}
