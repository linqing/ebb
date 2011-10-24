-- MySQL dump 10.13  Distrib 5.1.57, for apple-darwin10.8.0 (i386)
--
-- Host: localhost    Database: ebb
-- ------------------------------------------------------
-- Server version	5.1.57-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES UTF8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ebb_badwords`
--

DROP TABLE IF EXISTS `ebb_badwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_badwords` (
  `word` varchar(255) NOT NULL DEFAULT '',
  `replacement` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`word`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_badwords`
--

LOCK TABLES `ebb_badwords` WRITE;
/*!40000 ALTER TABLE `ebb_badwords` DISABLE KEYS */;
/*!40000 ALTER TABLE `ebb_badwords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_bans`
--

DROP TABLE IF EXISTS `ebb_bans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_bans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `ip_addr` varchar(23) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_bans`
--

LOCK TABLES `ebb_bans` WRITE;
/*!40000 ALTER TABLE `ebb_bans` DISABLE KEYS */;
/*!40000 ALTER TABLE `ebb_bans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_cats`
--

DROP TABLE IF EXISTS `ebb_cats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_cats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `sort_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_cats`
--

LOCK TABLES `ebb_cats` WRITE;
/*!40000 ALTER TABLE `ebb_cats` DISABLE KEYS */;
INSERT INTO `ebb_cats` VALUES (1,'Test Category',0);
/*!40000 ALTER TABLE `ebb_cats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_forums`
--

DROP TABLE IF EXISTS `ebb_forums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_forums` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `cat_id` int(11) NOT NULL DEFAULT '0',
  `descr` text NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `topics` int(11) NOT NULL DEFAULT '0',
  `posts` int(11) NOT NULL DEFAULT '0',
  `last_topic_id` int(11) NOT NULL DEFAULT '0',
  `sort_id` int(11) NOT NULL DEFAULT '0',
  `auth` varchar(10) NOT NULL DEFAULT '0011222223',
  `auto_lock` int(11) NOT NULL DEFAULT '0',
  `increase_post_count` int(1) NOT NULL DEFAULT '1',
  `hide_mods_list` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_forums`
--

LOCK TABLES `ebb_forums` WRITE;
/*!40000 ALTER TABLE `ebb_forums` DISABLE KEYS */;
INSERT INTO `ebb_forums` VALUES (1,'Test Forum',1,'This is a test forum for public testing.',1,1,1,1,0,'0011222223',0,1,0);
/*!40000 ALTER TABLE `ebb_forums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_members`
--

DROP TABLE IF EXISTS `ebb_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `email_show` int(1) NOT NULL DEFAULT '0',
  `passwd` varchar(32) NOT NULL DEFAULT '',
  `regdate` int(10) NOT NULL DEFAULT '0',
  `level` int(1) NOT NULL DEFAULT '0',
  `rank` varchar(255) NOT NULL DEFAULT '',
  `active` int(1) NOT NULL DEFAULT '0',
  `active_key` varchar(32) NOT NULL DEFAULT '',
  `banned` int(1) NOT NULL DEFAULT '0',
  `banned_reason` text NOT NULL,
  `last_login` int(10) NOT NULL DEFAULT '0',
  `last_login_show` int(1) NOT NULL DEFAULT '0',
  `last_pageview` int(10) NOT NULL DEFAULT '0',
  `hide_from_online_list` int(1) NOT NULL DEFAULT '0',
  `posts` int(11) NOT NULL DEFAULT '0',
  `template` varchar(255) NOT NULL DEFAULT '',
  `language` varchar(255) NOT NULL DEFAULT '',
  `date_format` varchar(255) NOT NULL DEFAULT '',
  `timezone` float NOT NULL DEFAULT '0',
  `dst` int(1) NOT NULL DEFAULT '0',
  `enable_quickreply` int(1) NOT NULL DEFAULT '0',
  `return_to_topic_after_posting` int(1) NOT NULL DEFAULT '0',
  `target_blank` int(1) NOT NULL DEFAULT '0',
  `hide_avatars` int(1) NOT NULL DEFAULT '0',
  `hide_userinfo` int(1) NOT NULL DEFAULT '0',
  `hide_signatures` int(1) NOT NULL DEFAULT '0',
  `auto_subscribe_topic` int(1) NOT NULL DEFAULT '0',
  `auto_subscribe_reply` int(1) NOT NULL DEFAULT '0',
  `avatar_type` int(1) NOT NULL DEFAULT '0',
  `avatar_remote` varchar(255) NOT NULL DEFAULT '',
  `displayed_name` varchar(255) NOT NULL DEFAULT '',
  `real_name` varchar(255) NOT NULL DEFAULT '',
  `signature` text NOT NULL,
  `birthday` int(8) NOT NULL DEFAULT '0',
  `location` varchar(255) NOT NULL DEFAULT '',
  `website` varchar(255) NOT NULL DEFAULT '',
  `occupation` varchar(255) NOT NULL DEFAULT '',
  `interests` varchar(255) NOT NULL DEFAULT '',
  `msnm` varchar(255) NOT NULL DEFAULT '',
  `yahoom` varchar(255) NOT NULL DEFAULT '',
  `aim` varchar(255) NOT NULL DEFAULT '',
  `icq` varchar(255) NOT NULL DEFAULT '',
  `jabber` varchar(255) NOT NULL DEFAULT '',
  `skype` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_members`
--

LOCK TABLES `ebb_members` WRITE;
/*!40000 ALTER TABLE `ebb_members` DISABLE KEYS */;
INSERT INTO `ebb_members` VALUES (1,'linqing01','linqing01@gmail.com',0,'b181976667f3e93d520282ce8555beb5',1319192826,3,'',1,'',0,'',0,0,0,0,0,'default','English','D M d, Y g:i a',0,0,1,1,0,0,0,0,0,0,0,'','linqing01','','',0,'','','','','','','','','','');
/*!40000 ALTER TABLE `ebb_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_moderators`
--

DROP TABLE IF EXISTS `ebb_moderators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_moderators` (
  `forum_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_moderators`
--

LOCK TABLES `ebb_moderators` WRITE;
/*!40000 ALTER TABLE `ebb_moderators` DISABLE KEYS */;
/*!40000 ALTER TABLE `ebb_moderators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_posts`
--

DROP TABLE IF EXISTS `ebb_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `poster_id` int(11) NOT NULL DEFAULT '0',
  `poster_guest` varchar(255) NOT NULL DEFAULT '',
  `poster_ip_addr` varchar(23) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `post_time` int(10) NOT NULL DEFAULT '0',
  `post_edit_time` int(10) NOT NULL DEFAULT '0',
  `post_edit_by` int(11) NOT NULL DEFAULT '0',
  `enable_bbcode` int(1) NOT NULL DEFAULT '1',
  `enable_smilies` int(1) NOT NULL DEFAULT '1',
  `enable_sig` int(1) NOT NULL DEFAULT '1',
  `enable_html` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_posts`
--

LOCK TABLES `ebb_posts` WRITE;
/*!40000 ALTER TABLE `ebb_posts` DISABLE KEYS */;
INSERT INTO `ebb_posts` VALUES (1,1,0,'UseBB Installer','127.0.0.1','Thanks for choosing UseBB! We wish you a lot of fun with your board!\n\nDon\'t forget to direct any feature requests and ideas for the next major release (2.0) to the [url=http://usebb.sourceforge.net/]development site[/url].',1319192829,0,0,1,1,1,0);
/*!40000 ALTER TABLE `ebb_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_searches`
--

DROP TABLE IF EXISTS `ebb_searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_searches` (
  `sess_id` varchar(32) NOT NULL DEFAULT '',
  `time` int(10) NOT NULL DEFAULT '0',
  `results` text NOT NULL,
  PRIMARY KEY (`sess_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_searches`
--

LOCK TABLES `ebb_searches` WRITE;
/*!40000 ALTER TABLE `ebb_searches` DISABLE KEYS */;
/*!40000 ALTER TABLE `ebb_searches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_sessions`
--

DROP TABLE IF EXISTS `ebb_sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_sessions` (
  `sess_id` varchar(32) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `ip_addr` varchar(23) NOT NULL DEFAULT '',
  `started` int(10) NOT NULL DEFAULT '0',
  `updated` int(10) NOT NULL DEFAULT '0',
  `location` varchar(255) NOT NULL DEFAULT '',
  `pages` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sess_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_sessions`
--

LOCK TABLES `ebb_sessions` WRITE;
/*!40000 ALTER TABLE `ebb_sessions` DISABLE KEYS */;
INSERT INTO `ebb_sessions` VALUES ('l9gld9c7s8sbcm4v7pqjvdso23',0,'127.0.0.1',1319192871,1319193105,'topic:1',5),('t70a0s01eh8ub67mbq5pgnvg82',0,'127.0.0.1',1319239810,1319239810,'index',1),('bsvctlqgqcc72egcrh9078jcq7',0,'127.0.0.1',1319264031,1319264031,'index',1);
/*!40000 ALTER TABLE `ebb_sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_stats`
--

DROP TABLE IF EXISTS `ebb_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_stats` (
  `name` varchar(255) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_stats`
--

LOCK TABLES `ebb_stats` WRITE;
/*!40000 ALTER TABLE `ebb_stats` DISABLE KEYS */;
INSERT INTO `ebb_stats` VALUES ('topics','1'),('posts','1'),('members','1'),('started','1319192829');
/*!40000 ALTER TABLE `ebb_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_subscriptions`
--

DROP TABLE IF EXISTS `ebb_subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_subscriptions` (
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_subscriptions`
--

LOCK TABLES `ebb_subscriptions` WRITE;
/*!40000 ALTER TABLE `ebb_subscriptions` DISABLE KEYS */;
/*!40000 ALTER TABLE `ebb_subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebb_topics`
--

DROP TABLE IF EXISTS `ebb_topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebb_topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) NOT NULL DEFAULT '0',
  `topic_title` varchar(255) NOT NULL DEFAULT '',
  `first_post_id` int(11) NOT NULL DEFAULT '0',
  `last_post_id` int(11) NOT NULL DEFAULT '0',
  `count_replies` int(11) NOT NULL DEFAULT '0',
  `count_views` int(11) NOT NULL DEFAULT '0',
  `status_locked` int(1) NOT NULL DEFAULT '0',
  `status_sticky` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebb_topics`
--

LOCK TABLES `ebb_topics` WRITE;
/*!40000 ALTER TABLE `ebb_topics` DISABLE KEYS */;
INSERT INTO `ebb_topics` VALUES (1,1,'Test Topic',1,1,0,1,0,0);
/*!40000 ALTER TABLE `ebb_topics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-10-24 19:36:53
