FROM openjdk:8
ADD build/libs/data-ingest-service.jar data-ingest-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "data-ingest-service.jar"]docker build -t