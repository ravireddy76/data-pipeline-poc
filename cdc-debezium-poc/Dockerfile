FROM openjdk:8
ADD build/libs/cdc-debezium-poc.jar cdc-debezium-poc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cdc-debezium-poc.jar"]docker build -t