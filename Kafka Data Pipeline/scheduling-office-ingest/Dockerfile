FROM openjdk:8
ADD build/libs/scheduling-office-ingest.jar scheduling-office-ingest.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "scheduling-office-ingest.jar"]docker build -t