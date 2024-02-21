FROM openjdk:21-jdk-slim AS build

WORKDIR /app

COPY target/mortgage-0.0.1-SNAPSHOT.jar mortgage.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "mortgage.jar"]