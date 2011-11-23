package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._

import common._
import http._
import sitemap._
import Loc._

import net.liftweb.mapper.{ DB, StandardDBVendor, DefaultConnectionIdentifier }
import org.squeryl._
import PrimitiveTypeMode._
import adapters.MySQLAdapter

class Boot {
  def boot {
    var input = this.getClass.getResourceAsStream("/db.properties")
    val db = new java.util.Properties
    db.load(input)

    SessionFactory.concreteFactory = Some(() => Session.create(
      java.sql.DriverManager.getConnection(db.getProperty("url"), db.getProperty("username"), db.getProperty("password")),
      new MySQLAdapter))

    S.addAround(new LoanWrapper {
      override def apply[T](f: => T): T = {
        inTransaction {
          f
        }
      }
    })

    // where to search snippet
    LiftRules.addToPackages("ebb")

    /*
    // Build SiteMap
    val entries = List(
      Menu.i("Home") / "index", // the simple way to declare a menu

      // more complex because this menu allows anything in the
      // /static path to be visible
      Menu(Loc("Static", Link(List("static"), true, "/static/index"),
               "Static Content")))

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap(SiteMap(entries:_*))
    */

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new XHtmlInHtml5OutProperties(r.userAgent))

    // Use jQuery 1.4
    LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

  }
}
