package model

object Deck {
  def init() = {

    List.fill(5)(Guard) ++
    List.fill(2)(Priest) ++
    List.fill(2)(Baron) ++
    List.fill(2)(Handmaid) ++
    List.fill(2)(Prince) ++
    List.fill(1)(King) ++
    List.fill(1)(Countess) ++
    List.fill(1)(Princess)
  }
}
