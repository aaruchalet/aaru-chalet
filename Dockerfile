FROM eclipse-temurin:21-jre

LABEL maintainer="manjeet.kumar"

WORKDIR /opt/chalet-core

COPY build/libs/*.jar chalet-core.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "chalet-core.jar"]