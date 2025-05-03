FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . /app/

RUN mvn clean install -DskipTests

FROM openjdk:21-slim

WORKDIR /opt/app

COPY --from=builder /app/target/*.jar /actions-and-kubernetes.jar

COPY dd-java-agent.jar /dd-java-agent.jar

EXPOSE 8080

ENV DD_SERVICE=actions-kubernetes-app \
    DD_ENV=dev \
    DD_VERSION=1.0 \
    DD_AGENT_HOST=host.docker.internal

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/actions-and-kubernetes.jar"]
