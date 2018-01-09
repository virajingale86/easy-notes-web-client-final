FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/easy-notes-web-0.0.1-SNAPSHOT.jar easy-notes-web.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easy-notes-web.jar"]