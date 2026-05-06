FROM maven:3.9.4-eclipse-temurin-21-alpine as build
LABEL MAINTAINER="Sambhav Mahajan"
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=build /app/target/emailasaservice-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]