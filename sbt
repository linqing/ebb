java -Xmx512M -XX:MaxPermSize=256M -Xss2M -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launcher.jar "$@"
