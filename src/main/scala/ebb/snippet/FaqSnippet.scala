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

  def render: CssSel = {
    S.param("id").flatMap(faqKey => FaqReader.findFaq(faqKey))
      .map(faq => {
        "._question_detail *" #> {
          "._question_title" #> faq.question &
          "._answer" #> faq.answer
        }
      }).openOr("._question_detail" #> "") & {
        "#faq-contents" #> {
          "._cat_questions" #> { // FIXME why <div class="_cat_questions"> is still in the final HTML
            for (groupName <- FaqReader.getGroupNames) yield {
              "._cat_name" #> groupName &
                "ul" #> {
                  for (faq <- FaqReader.getFaqList(groupName)) yield {
                    "li *" #> <a href={ "/faq.html?id=" + faq.key }>{ faq.question }</a>
                  }
                }
            }
          }
        }
      }
  }

}