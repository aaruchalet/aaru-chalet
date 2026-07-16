FROM eclipse-temurin:21-jre
LABEL maintainer="manjeet.kumar"
WORKDIR /opt/aaru-chalet
COPY build/libs/*.jar aaru-chalet.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","aaru-chalet.jar"]

