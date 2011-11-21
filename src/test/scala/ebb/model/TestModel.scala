package ebb.model

object TestModels {
  class CatImpl(
    val id: Long,
    val name: String,
    val sortId: Long) extends Cat

  val cats: List[Cat] = new CatImpl(1, "Test Category", 0) :: Nil

  val forums = new Forum(1, "Test Forum", 1, "This is a test forum for public testing.", 1, 1, 2, 1, 0, "0011222223", 0, 1, 0) :: Nil

  val topics = new Topic(1, 1, "Test Topic", 1, 2, 1, 3, false, false) :: Nil

  val posts = new Post(1, 1, 0, "Use BB Installer", "127.0.0.1", """Thanks for choosing UseBB! We wish you a lot of fun with your board!

Don't forget to direct any feature requests and ideas for the next major release (2.0) to the [url=http://usebb.sourceforge.net/]development site[/url].""",
    1319192829, 0, 0, true, true, true, false)
}