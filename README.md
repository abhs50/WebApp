Eclipse Project Setup : ( After create dynamic webproject and sync with the code base )

1. Create Database : DDL presesnt in code base. ( Inside WebContent )
2. Configure your mysql connections in resources/bean.xml file ( Try to keep it same , else we have to modify each time )
3. Add mysql , spring jars as defined the wesbite url : http://www.tutorialspoint.com/spring/spring_jdbc_example.htm
4. Right click project in eclipse : Add all jars to deployment assembly ->Properties -> Deployment Assembly -> Add -->
5. Add org.springframework.transaction.jar WebContent/WEB-INF/lib
5. Setup Tomcat : Tomcat 7.0.34 inside eclipse  
6. Deploy the WebApp

Spring version : spring-framework-4.0.0.M1-dist.zip
http://www.springsource.org/download/community

Spring Library setup :  http://www.tutorialspoint.com/spring/spring_environment_setup.htm

Spring JDBC : http://www.tutorialspoint.com/spring/spring_jdbc_example.htm
