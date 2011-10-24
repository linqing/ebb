package ebb.snippet

import net.liftweb.util._
import ebb.model.Models._
import org.squeryl._
import PrimitiveTypeMode._
import net.liftweb.util.Helpers._

object ForumSnippet {
  def forumlist: CssSel =
    "*" #> (for (cat <- cats) yield {
      ".t-cat_header" #> ("@cat_name" #> cat.name) &
        ".t-forum" #> (for (f <- cat.forums) yield {
          ".forumname *" #> f.name &
            ".forumdescr *" #> f.descr
        })
    })
}
