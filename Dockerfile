FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/easy-notes-web-0.0.1-SNAPSHOT.war easy-notes-web.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easy-notes-web.war"]