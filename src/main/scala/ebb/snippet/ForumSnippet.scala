package ebb
package snippet

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
      ".t-forum" #> ( for {
        f <- cat.forums
        lastTopic <- topics.lookup(f.last_topic_id)
      } yield {
        val lastPost = posts.lookup(lastTopic.last_post_id).get
        val lastPoster = members.lookup(lastPost.poster_id).get
        val lastTopicTitle = (if(lastTopic.count_replies>1) "Re: " else "") + lastTopic.topic_title
        ".forumname *" #> f.name &
        ".forumdescr *" #> f.descr &
        ".total_topics" #> f.topics &
        ".total_posts" #> f.posts &
        ".latest_post *" #> ("@latest_post" #> lastTopicTitle) &
        ".by_author *" #> ("@by_author" #> {lastPoster.name}) &
        ".on_date *" #> ("@on_date" #> new SimpleDateFormat().format(lastPost.post_time))
      })
    })
}