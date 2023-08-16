FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/crud_operation-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "crud_operation-0.0.1-SNAPSHOT.jar"]

