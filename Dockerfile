FROM maven:3.8.3-jdk-8 as builder

WORKDIR /app

COPY pom.xml ./
COPY src/ ./src/

RUN mvn package

FROM openjdk:8-jre-slim

WORKDIR /app
COPY --from=builder /app/target/figletcreatorservice.jar .

EXPOSE 9005
CMD ["java", "-jar", "/app/figletcreatorservice.jar"]