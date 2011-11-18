package ebb

import org.squeryl._
import org.squeryl.adapters.MySQLAdapter

trait DbConnection {
  def connect() {
    Class.forName("com.mysql.jdbc.Driver");
    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ebb", "root", "root"),
        new MySQLAdapter))

  }
}