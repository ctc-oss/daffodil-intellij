lazy val scala213      = "2.13.4"
lazy val pluginVersion = "2020.3.3.0" + sys.env.get("DAFFODIL_INTELLIJ_BUILD_NUMBER").fold("")("." + _)

ThisBuild / intellijPluginName := "daffodil-intellij"
ThisBuild / intellijBuild := "203"

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias(
  "check",
  "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck"
)

scalacOptions += "-deprecation"

lazy val `daffodil-intellij` = project
  .in(file("."))
  .enablePlugins(SbtIdeaPlugin)
  .settings(
    scalaVersion := scala213,
    version := pluginVersion,
    intellijPlugins := Seq(
      "com.intellij.java".toPlugin,
      "org.intellij.scala:2020.3.16".toPlugin
    ),
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-s", "-a", "+c", "+q"),
    patchPluginXml := pluginXmlOptions { xml =>
      xml.version = version.value
      xml.changeNotes = sys.env.getOrElse(
        "DAFFODIL_INTELLIJ_CHANGE_NOTES",
        s"""<![CDATA[
        <b>frist!</b>
        ]]>"""
      )
    }
  )

lazy val runner = createRunnerProject(`daffodil-intellij`)
