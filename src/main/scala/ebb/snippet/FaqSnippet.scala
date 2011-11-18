package ebb
package snippet

import net.liftweb.http._
import net.liftweb.util._
import ebb.model.Models._
import ebb.util.FaqReader
import org.squeryl._
import PrimitiveTypeMode._
import net.liftweb.util.Helpers._
import java.util._
import java.text._

object FaqSnippet {
  def questionList: CssSel = {
    "#faq-contents" #> (for (groupName <- FaqReader.getGroupNames) yield {
      "._cat_name" #> groupName &
        "ul" #> (for (question <- FaqReader.getFaqList(groupName)) yield {
          "._question_entry" #> question.question
        })
    })
  }
}