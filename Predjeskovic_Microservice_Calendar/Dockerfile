FROM openjdk:17-buster

RUN apt-get update
RUN apt-get install wget
RUN wget https://mirror.klaus-uwe.me/apache/tomcat/tomcat-9/v9.0.54/bin/apache-tomcat-9.0.54.tar.gz
RUN tar -xzvf apache-tomcat-9.0.54.tar.gz
RUN find apache-tomcat-9.0.54

EXPOSE 8081

ADD ./target/Predjeskovic_Microservice_Calendar-1.0-SNAPSHOT.war ./apache-tomcat-9.0.54/webapps


CMD ["./apache-tomcat-9.0.54/bin/catalina.sh", "run"]