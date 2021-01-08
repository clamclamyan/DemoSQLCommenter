# DemoSQLCommenter
 
1. Install mySQL locally from [here](https://dev.mysql.com/downloads/mysql/)
2. Configure */src/main/resources/application.properties* to use local mySQL user and password
3. Navigating to */var/log* of MacOS, create folder **mysql**
4. Create an **all.log** file inside this folder to record queries 
5. Within */usr/local* of MacOS, navigate to your mysql install directory and setup a configuration file **my.cnf**
6. Set properties inside my.cnf to enable logging and restart mySQL server
```
[mysqld]
general_log = on
general_log_file = /var/log/mysql/all.log
```
7. Alternatively, can set the logging of mySQL through mySQL command line when mySQL is running
```
set global general_log = 1;
set global log_output = 'file';
set global general_log_file = '/var/log/mysql/all.log';
```
8. Open the log file in terminal to detect the queries sent through requests in the demo. Open it with live updates with:
`sudo tail -f /var/log/mysql/all.log`
9. `gradle build`
10. Run program and enter sample data for new user then submit. Query should be visible with SQLCommenter comments in the terminal