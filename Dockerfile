FROM openjdk:17-jdk-slim
COPY ./target/crud_operation-0.0.1-SNAPSHOT.jar crud.jar
EXPOSE 8080
CMD ["java", "-jar", "crud.jar"]

