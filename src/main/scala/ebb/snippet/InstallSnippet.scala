package ebb
package snippet

import net.liftweb.http._
import net.liftweb.util._
import org.squeryl._
import PrimitiveTypeMode._
import net.liftweb.util.Helpers._
import java.util._
import java.text._

class InstallSnippet {
  private object dbName extends RequestVar("")
  def render: CssSel =
    "@dbName" #> SHtml.text(dbName.is, (s) => dbName(s)) &
    ":submit" #> SHtml.submit("Install", process _)
    
    def process {
      if (dbName.is == "ok") {
        // process
        S.redirectTo("/installSuccess")
      }
    }
}