FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . /app/

RUN mvn clean install -DskipTests

FROM openjdk:21-slim

WORKDIR /opt/app

COPY --from=builder /app/target/*.jar /actions-and-kubernetes.jar

COPY dd-java-agent.jar /dd-java-agent.jar

EXPOSE 8080

ARG DD_HOSTNAME
ARG DD_SERVICE
ARG DD_VERSION
ARG DD_ENV

ENV DD_HOSTNAME=$DD_HOSTNAME \
    DD_SERVICE=$DD_SERVICE \
    DD_VERSION=$DD_VERSION \
    DD_ENV=$DD_ENV \
    DD_PROFILING_ENABLED=true \
    DD_LOGS_INJECTION=true \
    DD_IAST_ENABLED=true \
    DD_APPSEC_SCA_ENABLED=true

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/actions-and-kubernetes.jar"]
