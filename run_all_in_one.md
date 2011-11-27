How to run the all-in-one package
=================================

Requirements:
-------------

1. Jdk 1.6+
2. MySql 5.x

1. Download the file
-----------------------

Download the the "ebb-bin.war" from the "all-in-one" directory

2. Create database
------------------

	mysql -uroot -e 'create database ebb'
    mysql -uroot < mysql/database.sql

Note an empty string used as the password by default. If you have a different mysql configuration, please modify "src/main/resources/db.properties" before continuing.

3. Start ebb
------------

Uncompress "ebb-bin.war" to "ebb-bin".

If you are running on windows, run:

    cd ebb-bin
    ./run.bat

On linux, then:

    cd ebb-bin
    chmod +x ./run.sh
    ./run.sh

The embedded jetty server will be started now, you can visit it from your browser: http://localhost:8080

4. Or put it in a jetty server
------------------------------

There is another way to run ebb. Because "ebb-bin.war" is a standard java web app, you can just put it in a running servlet server like Tomcat/Jetty. 