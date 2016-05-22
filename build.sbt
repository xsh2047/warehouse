name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

// Resolver is needed only for SNAPSHOT versions
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"


libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3-SNAPSHOT",
  filters,
  "org.webjars" % "bootstrap" % "3.3.6",
  "org.webjars" % "jquery" % "2.2.3"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
