import org.mortbay.jetty.Server
import org.mortbay.jetty.webapp.WebAppContext

/**
 * A Jetty starter to start the ebb in command line. You can pass the port as the only parameter.
 *
 * It will be used in "run.sh" or "run.bat"
 */
object JettyServer {

  def main(args: Array[String]) {
    val port = args match {
      case Array(p) => p.toInt
      case _ => 8080
    }
    val server = new Server(port)
    val context = new WebAppContext()
    context.setContextPath("/");
    context.setResourceBase("../../");
    context.setParentLoaderPriority(true);
    server.addHandler(context);
    server.start();
    server.join();
  }

}