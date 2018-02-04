package model

import org.scalatest.{FreeSpec, Matchers}


class RoleTest extends FreeSpec with Matchers {

  "Role" - {
    "should have greet with name and value" in {
      val prince =  Prince
      prince.greeting shouldEqual "Hello I am the Prince, I have a value of 5"
    }
  }
}
