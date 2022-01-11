FROM openjdk:17-alpine
EXPOSE 8761
ADD target/ServiceRegistry-0.0.1-SNAPSHOT.jar ServiceRegistry.jar

ENTRYPOINT ["java","-jar","/ServiceRegistry.jar"]