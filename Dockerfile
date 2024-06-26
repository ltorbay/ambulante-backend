FROM openjdk:11

WORKDIR /api

ARG buildVersion
COPY target/ambulante-backend-${buildVersion}.jar /api/ambulante-backend.jar

ENTRYPOINT ["java", "-jar", "/api/ambulante-backend.jar"]
