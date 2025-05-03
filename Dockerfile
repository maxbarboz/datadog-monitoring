FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . /app/

RUN mvn clean install -DskipTests

FROM openjdk:21-slim

WORKDIR /opt/app

COPY --from=builder /app/target/*.jar /actions-and-kubernetes.jar

COPY dd-java-agent.jar /dd-java-agent.jar

EXPOSE 8080

ENV DD_AGENT_HOST="datadog-agent" \
    DD_TRACE_AGENT_PORT="8126" \
    DD_PROFILING_ENABLED=true \
    DD_LOGS_INJECTION=true \
    DD_IAST_ENABLED=true \
    DD_APPSEC_SCA_ENABLED=true \
    DD_SERVICE="java-dd-trace-stg" \
    DD_VERSION="1.0.0" \
    DD_ENV="staging"

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/actions-and-kubernetes.jar"]
