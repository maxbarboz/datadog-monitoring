FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . /app/

RUN mvn clean install -DskipTests

FROM openjdk:21-slim

WORKDIR /opt/app

COPY --from=builder /app/target/*.jar /actions-and-kubernetes.jar

COPY dd-java-agent.jar /dd-java-agent.jar

EXPOSE 8080

ARG DD_AGENT_HOST
ARG DD_SERVICE

ENV DD_AGENT_HOST=$DD_AGENT_HOST \
    DD_SERVICE=$DD_SERVICE \
    DD_VERSION="0.0.1" \
    DD_ENV="dev" \
    DD_PROFILING_ENABLED=true \
    DD_LOGS_INJECTION=true \
    DD_IAST_ENABLED=true \
    DD_APPSEC_SCA_ENABLED=true

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/actions-and-kubernetes.jar"]
