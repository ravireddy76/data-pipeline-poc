### Introduction
This is data enrichment service is micro service application to read and validate/format the data.

### Getting Started
To set up, build and run poc application in LOCAL environment.
1.	Clone or download from github (https://github.com/ravireddy76/data-pipeline-poc)
2.	Open Project cdc-debezium-poc in IntelliJ/Eclipse
3.  For lombok plugin configuration please follow steps https://www.baeldung.com/lombok-ide
3.	Build ``` ./gradlew clean build ```
4.	Run the application by right click  CdcDebeziumApplication class
    OR using gradle command  ``` ./gradlew bootRun ```

### For Postgres Database with debezium logical decoding plugin
 - [Postgres with logical decoding plugin Docker](https://hub.docker.com/r/debezium/postgres)
 - [Exisiting Postgres](https://debezium.io/documentation/reference/postgres-plugins.html)

### Steps to install logical decoding plugin for existing postgres DB server
https://debezium.io/documentation/reference/postgres-plugins.html

### Endpoint Information
Swagger Documentation : http://localhost:8085/swagger-ui.html
- Health Check:
```
 create data points and clusters :
    GET -> http://localhost:8089/cdcpoc/heartbeat
    Headers -> "Content-Type":"application/json"
               "Accept-Charset":"UTF-8"
```
### Jar file execution option 2 run application
 - Open command line prompt
 - Go to (cd to) project folder
 - Go to build/libs directory
 - execute command  ``` java -jar cdc-debezium-poc.jar ```
 - http://localhost:8089/swagger-ui.html

### Docker Option 2 run application
 - To build docker image from docker file
   ``` docker build -t cdc-debezium-poc .```
 - To run created docker image  ``` docker run -p 8089:8089 -t cdc-debezium-poc ```
 - http://localhost:8089/swagger-ui.html

### Contribute
Ravi Reddy (Ravinder Nancherla)

### License
@CopyRight ( C ) All rights reserved to Ravi Reddy POC World. It's Illegal to reproduce this code.
[Ravi Reddy](https://www.linkedin.com/in/ravireddy55447/)
