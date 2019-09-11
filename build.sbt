name := """testcomp"""
organization := "com.example"

version := "0.1"

scalaVersion in ThisBuild := "2.13.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

lazy val root = (project in file("."))
.enablePlugins(PlayScala)
.aggregate(module1,proto)
.dependsOn(module1,proto)
 
lazy val proto = (project in file("modules/common/src/main/scala"))
  .settings(
    PB.protoSources in Compile := Seq(baseDirectory.value / "modules/common/src/protobuf"),
    PB.targets in Compile := Seq(
      scalapb.gen() -> baseDirectory.value / "modules/common/src/main/scala"
    ),
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %%% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion,
      "com.thesamet.scalapb" %%% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
    )
  )

lazy val module1 = (project in file("modules/module1"))
.enablePlugins(PlayScala)
.dependsOn(proto)

