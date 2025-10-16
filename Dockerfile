# Use official OpenJDK 22 image
FROM eclipse-temurin:22-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar built by Maven
COPY target/Cold-Emailing-0.0.1-SNAPSHOT.jar app.jar

# Expose port (match Spring Boot port, default 8080)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
