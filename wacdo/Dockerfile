FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY wacdo/pom.xml .
COPY wacdo/src ./src
RUN mvn clean package -DskipTests -Dproject.build.sourceEncoding=UTF-8 -Dmaven.resources.filtering=false

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY .env .env
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
