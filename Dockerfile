FROM openjdk:19
MAINTAINER Bokov Evgeniy
COPY target/TutoringApp-0.0.1-SNAPSHOT.jar TutoringApp.jar
ENTRYPOINT ["java", "-jar", "/TutoringApp.jar"]
