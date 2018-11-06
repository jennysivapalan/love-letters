package exceptions

case class NothingLeftInDeckException(msg:String)  extends Exception(msg)
case class ActionNotPlayableOnHandmaid(msg:String)  extends Exception(msg)
case class PlayerIsOutOfRound(msg:String)  extends Exception(msg)
