# Stage 1: Build the JAR file
FROM maven:3.8.8-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:11-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/virtualcaddymaven-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]