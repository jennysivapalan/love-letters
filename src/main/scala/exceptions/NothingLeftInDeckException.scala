package exceptions

case class NothingLeftInDeckException(msg:String)  extends Exception(msg)
