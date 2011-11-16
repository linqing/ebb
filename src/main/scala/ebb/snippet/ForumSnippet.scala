package ebb
package snippet

import net.liftweb.http._
import net.liftweb.util._
import ebb.model.Models._
import org.squeryl._
import PrimitiveTypeMode._
import net.liftweb.util.Helpers._
import java.util._
import java.text._

object ForumSnippet {
  def forumlist: CssSel =
    "*" #> (for (cat <- cats) yield {
      ".t-cat_header" #> ("@cat_name" #> cat.name) &
        ".t-forum" #> (for {
          f <- cat.forums
          lastTopic <- topics.lookup(f.lastTopicId)
        } yield {
          val lastPost = posts.lookup(lastTopic.lastPostId).get
          val lastPoster = members.lookup(lastPost.posterId).get
          val lastTopicTitle = (if (lastTopic.countReplies > 1) "Re: " else "") + lastTopic.topicTitle
          ".forumname *" #> f.name &
            ".forumdescr *" #> f.descr &
            ".total_topics" #> f.topics &
            ".total_posts" #> f.posts &
            ".latest_post *" #> ("@latest_post" #> lastTopicTitle) &
            ".by_author *" #> ("@by_author" #> { lastPoster.name }) &
            ".on_date *" #> ("@on_date" #> new SimpleDateFormat().format(lastPost.postTime))
        })
    })

  def show: CssSel = {
    "*" #> (for {
      forumId <- S.param("id")
      forum <- forums.lookup(forumId.toLong)
    } yield {
      "@topic *" #> {
        "@name *" #> forum.name &
          "@posts *" #> forum.posts
      }
    })
  }

  def topic: CssSel = {
    ".maintable *" #> (for {
      topicId <- S.param("id")
      topic <- topics.lookup(topicId.toLong)
      post <- posts.lookup(topicId.toLong)
    } yield {
      // TODO why can't 
      /*
       * Option(xx) match {
       * } & ".xxx" #> "??"
       */
      val x = Option(post.posterId) match {
        case Some(id) => {
          val poster = members.lookup(id).get
          ".posternamecontainer *" #> poster.name &
            "._registered" #> new SimpleDateFormat("MMM yy").format(post.postTime) &
            "._posts" #> poster.posts &
            "._location" #> poster.location
        }
        case _ => {
          ".posternamecontainer *" #> post.posterGuest &
            "._registered" #> "" &
            "._posts" #> "" &
            "._location" #> ""
        }
      }
      x &
        "._postdate" #> new SimpleDateFormat("MMM yy").format(post.postTime) &
        "._poster_avatar" #> "???" &
        "._post_content" #> post.content &
        "._poster_sig" #> "???" &
        "._post_editinfo" #> "???" &
        "._poster_ip_addr" #> post.posterIpAddr
    })
  }
}
