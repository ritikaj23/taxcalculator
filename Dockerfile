# Use OpenJDK 11 as the base image
FROM openjdk:11-jre-slim

WORKDIR /app


COPY target/taxcalculator-0.0.1-SNAPSHOT.jar /usr/app/taxcalculator.jar

CMD ["java", "-jar", "taxcalculator.jar"]


