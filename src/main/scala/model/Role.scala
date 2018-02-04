package model
//
//object RoleName extends Enumeration {
//  type = Value
//  val GUARD, PRINCE = Value
//}
//
//case class Role(name: RoleName, value: Int) {
//  def greeting = s"Hello I am the $name, I have a value of $value"
//}

//object Role extends Role(name: String)

sealed abstract class Role( val name: String,  val value: Int) {
  def greeting = s"Hello I am the $name, I have a value of $value"

}
object Guard extends Role("Guard", 1)
object Prince extends Role("Prince", 5)

