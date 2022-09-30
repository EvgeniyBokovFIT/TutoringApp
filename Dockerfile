FROM openjdk:19-jdk-alpine3.16
MAINTAINER Bokov Evgeniy
WORKDIR /opt/app
COPY target/TutoringApp-0.0.1-SNAPSHOT.jar TutoringApp.jar
ENTRYPOINT ["java", "-jar", "TutoringApp.jar"]