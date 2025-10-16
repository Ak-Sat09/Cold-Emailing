# Use official OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY target/Cold-Emailing-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081   
ENTRYPOINT ["java", "-jar", "app.jar"]
