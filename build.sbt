name := """irctest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "pircbot" % "pircbot" % "1.5.0",
  jdbc,
  anorm,
  cache,
  ws
)
