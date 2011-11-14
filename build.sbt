name := "projname"

scalaVersion := "2.8.1"

seq(webSettings: _*)

// If using JRebel
jettyScanDirs := Nil

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
  "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty", // For Jetty 7
  // "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty,test", // For Jetty 6, add scope test to make jetty avl. for tests
  "mysql" % "mysql-connector-java" % "5.1.10",
   "org.scalatest" %% "scalatest" % "1.5.1" % "compile->default",
  // "org.scala-tools.testing" % "specs_2.8.1" % "1.6.8" % "test", // For specs.org tests
  // "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "com.h2database" % "h2" % "1.2.138", // In-process database, useful for development systems
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default" // Logging
)
