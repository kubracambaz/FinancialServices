
########Maven build stage########
FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

########JRE run stage########
FROM openjdk:17-jdk-slim
WORKDIR app
COPY --from=build target/*.jar account.jar
ENTRYPOINT ["java", "-jar", "account.jar"]
