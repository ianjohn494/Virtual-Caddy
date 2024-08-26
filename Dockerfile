# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the build argument for the JAR file name
ARG JAR_FILE=target/virtualcaddymaven-0.0.1-SNAPSHOT.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]