package ebb
package snippet

import net.liftweb.http._
import net.liftweb.util._
import org.squeryl._
import PrimitiveTypeMode._
import net.liftweb.util.Helpers._
import java.util._
import java.text._
import scala.xml.NodeSeq

class Register {
  private object username extends RequestVar("")
  def render: CssSel =
    "@dbName" #> SHtml.text(username.is, (s) => username(s)) &
      ":submit" #> SHtml.submit("Install", process _)

  def process {
    if (username.is == "ok") {
      // process
      S.redirectTo("/installSuccess")
    }
  }
}
