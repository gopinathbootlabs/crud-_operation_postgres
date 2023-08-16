FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
EXPOSE 8080
CMD ["java", "-jar", "./target/crud_operation-0.0.1-SNAPSHOT.jar"]

