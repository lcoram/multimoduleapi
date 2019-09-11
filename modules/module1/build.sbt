name := "module1"
description := "a test module."

version := "0.1"

scalaVersion := "2.13.0"

PlayKeys.devSettings += ("play.http.router", "module1.Routes")
