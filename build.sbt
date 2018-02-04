
import sbt.Keys._
import sbt._

name := "Loveletters"
version := "1.0"
scalaVersion := "2.12.4"

lazy val root = (project in file("."))


libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
