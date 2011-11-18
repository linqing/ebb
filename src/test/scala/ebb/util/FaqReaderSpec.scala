package ebb.model

import ebb.util.FaqReader
import org.scalatest.Spec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers
import Models._

import org.squeryl._
import adapters.MySQLAdapter
import PrimitiveTypeMode._

/**
 * This is the spec of FaqReader.
 */
class FaqReaderSpec extends Spec with ShouldMatchers {

  describe("The faq reader") {
    it("should get all groups in file faq.txt") {
      val names = FaqReader.getGroupNames
      names should not be 'empty
      names.size should be(6)

      // check orders
      names.first should be("User Accounts")
      names.last should be("UseBB Issues")
    }

    it("shold get the questions of a group") {
      val faqList = FaqReader.getFaqList("User Accounts")
      faqList should not be 'empty
      faqList.size should be(8)
    }

    it("should get the question and answer correctly") {
      val faqList = FaqReader.getFaqList("User Accounts")
      val faq = faqList(7)

      faq.key should not be 'empty
      faq.key.length should be >= 5
      faq.question should equal("Can I change my rank?")
      faq.answer should equal("No, only administrators can give users a custom rank.")
    }

    it("should get a question by key") {
      val faqList = FaqReader.getFaqList("User Accounts")
      val faq = faqList.first
      val key = faq.key

      val found = FaqReader.getQuestion(key)
      found should not be None
      found.get.question should equal(faq.question)
    }
  }
}