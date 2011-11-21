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
  @Column("ip_addr")
  val ipAddr: String) extends KeyedEntity[Long]

class Cat(
  val id: Long,
  val name: String,
  @Column("sort_id")
  val sortId: Long) extends KeyedEntity[Long] {
  lazy val forums: OneToMany[Forum] = Models.catToForums.left(this)
}

class Forum(
  val id: Long,
  val name: String,
  val cat_id: Long,
  val descr: String,
  val status: Int,
  @Column("topics")
  val topicCount: Int,
  val posts: Long,
  @Column("last_topic_id")
  val lastTopicId: Long,
  @Column("sort_id")
  val sortId: Long,
  val auth: String,
  @Column("auto_lock")
  val autoLock: Long,
  @Column("increase_post_count")
  val increasePostCount: Int,
  @Column("hide_mods_list")
  val hideModsList: Long) extends KeyedEntity[Long] {
  lazy val mediators = Models.forumMediators.left(this)
  lazy val topics = Models.forumToTopics.left(this)
}

class Member(
  val id: Long,
  val name: String,
  val email: String,
  @Column("email_show")
  val emailShow: Boolean,
  val passwd: String,
  val regdate: Long,
  val level: Long,
  val rank: String,
  val active: Boolean,
  @Column("active_key")
  val activeKey: String,
  val banned: Boolean,
  val banned_reason: String,
  @Column("last_login")
  val last_login: Long,
  @Column("last_login_show")
  val lastLoginShow: Boolean,
  @Column("last_pageview")
  val lastPageview: Long,
  @Column("hide_from_online_list")
  val hideFromOnlineList: Boolean,
  val posts: Long,
  val template: String,
  val language: String,
  @Column("date_format")
  val dateFormat: String,
  val timezone: Double,
  val dst: Int,
  @Column("enable_quickreply")
  val enableQuickreply: Boolean,
  @Column("return_to_topic_after_posting")
  val returnToTopicAfterPosting: Boolean,
  @Column("target_blank")
  val targetBlank: Boolean,
  @Column("hide_avatars")
  val hideAvatars: Boolean,
  @Column("hide_userinfo")
  val hideUserinfo: Boolean,
  @Column("hide_signatures")
  val hideSignatures: Boolean,
  @Column("auto_subscribe_topic")
  val autoSubscribeTopic: Boolean,
  @Column("auto_subscribe_reply")
  val autoSubscribeReply: Boolean,
  @Column("avatar_type")
  val avatarType: Int,
  @Column("avatar_remote")
  val avatarRemote: String,
  @Column("displayed_name")
  val displayedName: String,
  @Column("real_name")
  val realName: String,
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
  val skype: String) extends KeyedEntity[Long] {
  lazy val forums = Models.forumMediators.right(this)
}

class Moderators(
  @Column("forum_id")
  val forumId: Long,
  @Column("user_id")
  val userId: Long) extends KeyedEntity[CompositeKey2[Long, Long]] {
  def id = compositeKey(forumId, userId)
}

class Post(
  val id: Long,
  @Column("topic_id")
  val topicId: Long,
  @Column("poster_id")
  val posterId: Long,
  @Column("poster_guest")
  val posterGuest: String,
  @Column("poster_ip_addr")
  val posterIpAddr: String,
  val content: String,
  @Column("post_time")
  val postTime: Long,
  @Column("post_edit_time")
  val postEditTime: Long,
  @Column("post_edit_by")
  val postEditBy: Long,
  @Column("enable_bbcode")
  val enableBbcode: Boolean,
  @Column("enable_smilies")
  val enableSmilies: Boolean,
  @Column("enable_sig")
  val enableSig: Boolean,
  @Column("enable_html")
  val enableHtml: Boolean) extends KeyedEntity[Long]

class Search(
  @Column("sess_id") val id: String,
  val time: Long,
  val results: String) extends KeyedEntity[String]

class Session(
  @Column("sess_id") val id: String,
  val user_Id: Long,
  @Column("ip_addr")
  val ipAddr: String,
  val started: Long,
  val updated: Long,
  val location: String,
  val pages: Long) extends KeyedEntity[String]

class Stat(
  @Column("name") val id: String,
  val content: String) extends KeyedEntity[String]

class Subscription(
  @Column("topic_id")
  val topicId: Long,
  @Column("user_id")
  val userId: Long)

class Topic(
  val id: Long,
  @Column("forum_id")
  val forumId: Long,
  @Column("topic_title")
  val topicTitle: String,
  @Column("first_post_id")
  val firstPostId: Long,
  @Column("last_post_id")
  val lastPostId: Long,
  @Column("count_replies")
  val countReplies: Long,
  @Column("count_views")
  val countViews: Long,
  @Column("status_locked")
  val statusLocked: Boolean,
  @Column("status_sticky")
  val statusSticky: Boolean) extends KeyedEntity[Long] {
  lazy val posts: OneToMany[Post] = Models.topicToPosts.left(this)
}

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
      via((c, f) => c.id === f.cat_id)
  val topicToPosts =
    oneToManyRelation(topics, posts).via((t, p) => t.id === p.topicId)
  val forumMediators = manyToManyRelation(forums, members, "ebb_moderators").
    via[Moderators]((forum, member, moderator) => (moderator.forumId === forum.id, member.id === moderator.userId))
  val forumToTopics =
    oneToManyRelation(forums, topics).
      via((f, t) => f.id === t.forumId)
}
