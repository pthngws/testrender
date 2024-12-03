
FROM openjdk:21-jdk-slim AS build
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests


# Run stage

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /target/websiteSellingLaptop-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]