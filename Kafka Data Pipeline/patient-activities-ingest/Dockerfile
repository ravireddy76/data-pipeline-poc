FROM openjdk:8
ADD build/libs/patient-activities-ingest.jar patient-activities-ingest.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "patient-activities-ingest.jar"]docker build -t