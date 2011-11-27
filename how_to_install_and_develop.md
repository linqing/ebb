How to install and run ebb
==========================

Requirements:
-------------

1. Git
2. Jdk 1.6+
3. Scala 2.9.1
4. MySql 5.x

1. Clone the source
-------------------

    git clone git://github.com/linqing/ebb.git
    
There will be directory named "ebb" created on your path.

This is a read-only repository. If you want to contribute, please contact us.

2. Create database
------------------

	mysql -uroot -e 'create database ebb'
    mysql -uroot < mysql/database.sql

Note an empty string used as the password by default. If you have a different mysql configuration, please modify "src/main/resources/db.properties" before continuing.

3. Run sbt
----------

    sbt container:start

Sbt will download all necessary libraries to compile the sources, may take a long time. It will totally download 200M+ jars. Let's f**k the GFW if it takes you hours and you're in China.

After that, it'll start a jetty server, and everything is ready.

4. Visit
--------

Open your browser and visit: http://localhost:8080 to see the homepage.
