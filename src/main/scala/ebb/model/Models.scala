package ebb.model

import org.squeryl._
import org.squeryl.dsl._
import org.squeryl.PrimitiveTypeMode._
import annotations.Column
import java.util.Date
class Badword(
  @Column("word") val id: String,
  val replacement: String) extends KeyedEntity[String]

class Ban(
  val id: Long,
  val name: String,
  val email: String,
  val ip_addr: String) extends KeyedEntity[Long]

class Cat(
  val id: Long,
  val name: String,
  val sort_id: Long) extends KeyedEntity[Long] {
  lazy val forums: OneToMany[Forum] = Models.catToForums.left(this)
}

class Forum(
  val id: Long,
  val name: String,
  val cat_id: Long,
  val descr: String,
  val status: Int,
  val topics: Long,
  val posts: Long,
  val last_topic_id: Long,
  val sort_id: Long,
  val auto_lock: Long,
  val increase_post_count: Int,
  val hide_mods_list: Long) extends KeyedEntity[Long]

class Member(
  val id: Long,
  val name: String,
  val email: String,
  val email_show: Boolean,
  val passwd: String,
  val regdate: Long,
  val level: Long,
  val rank: String,
  val active: Boolean,
  val active_key: String,
  val banned: Boolean,
  val banned_reason: String,
  val last_login: Long,
  val last_login_show: Boolean,
  val last_pageview: Long,
  val hide_from_online_list: Boolean,
  val posts: Long,
  val template: String,
  val language: String,
  val date_format: String,
  val timezone: Double,
  val dst: Int,
  val enable_quickreply: Boolean,
  val return_to_topic_after_posting: Boolean,
  val target_blank: Boolean,
  val hide_avatars: Boolean,
  val hide_userinfo: Boolean,
  val hide_signatures: Boolean,
  val auto_subscribe_topic: Boolean,
  val auto_subscribe_reply: Boolean,
  val avatar_type: Int,
  val avatar_remote: String,
  val displayed_name: String,
  val real_name: String,
  val signature: String,
  val birthday: Long,
  val location: String,
  val website: String,
  val occupation: String,
  val interests: String,
  val msnm: String,
  val yahoom: String,
  val aim: String,
  val icq: String,
  val jabber: String,
  val skype: String) extends KeyedEntity[Long]
//class Moderators(
//  val forum_id: Long,
//  val user_id: Long) extends IndirectKeyedEntity

class Post(
  val id: Long,
  val topic_id: Long,
  val poster_id: Long,
  val poster_guest: String,
  val poster_ip_addr: String,
  val content: String,
  val post_time: Long,
  val post_edit_time: Long,
  val post_edit_by: Long,
  val enable_bbcode: Boolean,
  val enable_smilies: Boolean,
  val enable_sig: Boolean,
  val enable_html: Boolean) extends KeyedEntity[Long]

class Search(
  @Column("sess_id") val id: String,
  val time: Long,
  val results: String) extends KeyedEntity[String]

class Session(
  @Column("sess_id") val id: String,
  val user_id: Long,
  val ip_addr: String,
  val started: Long,
  val updated: Long,
  val location: String,
  val pages: Long) extends KeyedEntity[String]

class Stat(
  @Column("name") val id: String,
  val content: String) extends KeyedEntity[String]

class Subscription(
  val topic_id: Long,
  val user_id: Long)

class Topic(
  val id: Long,
  val forum_id: Long,
  val topic_title: String,
  val first_post_id: Long,
  val last_post_id: Long,
  val count_replies: Long,
  val status_locked: Boolean,
  val status_sticky: Boolean) extends KeyedEntity[Long]

object Models extends Schema {
  val badwords = table[Badword]("ebb_badwords")
  val bans = table[Ban]("ebb_bans")
  val cats = table[Cat]("ebb_cats")
  val forums = table[Forum]("ebb_forums")
  val members = table[Member]("ebb_members")
  val posts = table[Post]("ebb_posts")
  val searches = table[Search]("ebb_searches")
  val sessions = table[Session]("ebb_sessions")
  val stats = table[Stat]("ebb_stats")
  val topics = table[Topic]("ebb_topics")
  val catToForums =
    oneToManyRelation(cats, forums).
      via((c, f) => c.id === f.cat_id )
}
