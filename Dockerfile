# Use a more standard official image
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]