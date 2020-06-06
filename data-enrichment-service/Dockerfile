FROM openjdk:8
ADD build/libs/data-enrichment-service.jar data-enrichment-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "data-enrichment-service.jar"]docker build -t