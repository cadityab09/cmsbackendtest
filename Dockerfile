# Use Maven to build the application with JDK 21
FROM maven:3.9.8-amazoncorretto-21-al2023 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK 21 to run the application
FROM openjdk:21-slim-bullseye
WORKDIR /app
COPY --from=build /app/target/deployment-project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
