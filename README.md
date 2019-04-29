#Group 4 Morning project

Might still be available online at https://school-magazine.leloctai.com

##Tested environment
 - Runtime: Java 1.8
 - Web Server: Glassfish 5.0.0
 - Database: MariaDB 10.3
 
## Running
 - Open root folder in an IDE. Tested with IntelliJ and NetBeans
 - Register the jars files in WebContent/WEB-INF/lib/* if neccessary
 - Connect to the database server using perferred tool and run database/ddl.sql to create the required tables and procedures
 - If you use a local database, use either the IDE or Glassfish admin page to set the following system properties (-D flags):
```
DB_URL="localhost"
DB_USER="YOUR_DB_USER"
DB_PASS="YOUR_DB_PASSWORD"
``` 