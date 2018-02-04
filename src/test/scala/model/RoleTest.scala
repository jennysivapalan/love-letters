package model

import org.scalatest.{FreeSpec, Matchers}


class RoleTest extends FreeSpec with Matchers {

  "A Role" - {
    "should have a value" in {
      val points = Rules.points(Prince)
      points shouldEqual(5)
    }
  }
}
