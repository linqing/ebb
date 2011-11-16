package ebb.model

import org.scalatest.Spec
import org.scalatest.BeforeAndAfter
import Models._

import org.squeryl._
import adapters.MySQLAdapter
import PrimitiveTypeMode._

class ModelSpec extends Spec with BeforeAndAfter {
  before {
    Class.forName("com.mysql.jdbc.Driver");
    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ebb", "root", ""),
        new MySQLAdapter))
  }
  describe("A Model") {
    it("should open all tables") {
      inTransaction {
        for (badword <- badwords) println(badword.replacement)
        for (ban <- bans) println(ban.name)
        for (cat <- cats) println(cat.name)
        for (forum <- forums) println(forum.name)
        for (member <- members) println(member.name)
        for (post <- posts) println(post.content)
        for (search <- searches) println(search.results)
        for (session <- sessions) println(session)
        for (stat <- stats) println(stat)
        for (topic <- topics) println(topic)
      }
    }
  }

  describe("Model Relations") {
    it("should open relatons") {
      inTransaction {
        topics.firstOption.foreach { topic =>
          println(topic.posts.size)
        }

        forums.firstOption.foreach { forum =>
          println(forum.mediators.size)
        }

        members.firstOption.foreach { member =>
          println(member.forums.size)
        }
      }
    }
  }
}
