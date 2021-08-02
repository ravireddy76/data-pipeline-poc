FROM openjdk:8
ADD build/libs/rules-meaningfule-mgt-ingest.jar rules-meaningfule-mgt-ingest.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "rules-meaningfule-mgt-ingest.jar"]docker build -t