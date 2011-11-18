name := "ebb"

scalaVersion := "2.9.1"

seq(webSettings: _*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

// If using JRebel
// jettyScanDirs := Nil

retrieveManaged := true

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.4-M5" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile->default")
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
   "mysql" % "mysql-connector-java" % "5.1.10",
   "org.scalatest" %% "scalatest" % "1.6.1" % "compile->default",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "com.h2database" % "h2" % "1.2.138", // In-process database, useful for development systems
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default" // Logging
)


