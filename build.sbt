name := """testcomp"""
organization := "com.example"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test


lazy val root = (project in file(".")).enablePlugins(PlayScala)
.aggregate(module1)
.dependsOn(module1)

lazy val module1 = (project in file("modules/module1"))
  .enablePlugins(PlayScala)

