FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Happy-Trip-App-0.0.3-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]