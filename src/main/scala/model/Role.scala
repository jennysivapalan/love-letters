package model

sealed abstract class Role
object Guard extends Role
object Priest extends Role
object Baron extends Role
object Handmaid extends Role
object Prince extends Role
object King extends Role
object Countess extends Role
object Princess extends Role

object Rules {

  def points(role: Role) = {
    role match {
      case Guard => 1
      case Prince => 5
      case _ => 0
    }
  }
}

