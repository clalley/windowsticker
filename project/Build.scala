import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "windowsticker"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaJpa,
//    javaEbean,
//   "mysql" % "mysql-connector-java" % "5.1.18"
    "postgresql" % "postgresql" % "9.1-901.jdbc4",
//    "org.hibernate" % "hibernate-entitymanager" % "4.2.4.Final"
    "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
