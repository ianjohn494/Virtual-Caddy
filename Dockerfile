FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/virtualcaddymaven-0.0.1-SNAPSHOT.jar virtualcaddy.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/virtualcaddy.jar"]