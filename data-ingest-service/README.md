### Introduction
This is data-ingest-service is micro service application to compute kafka messages and ingest data into destination database.


### Getting Started
To set up, build and run poc application in LOCAL environment.
1.	Clone or download from github (https://github.com/ravireddy76/docker-compose)
2.	Open Project data-ingest-service in IntelliJ/Eclipse
3.  For lombok plugin configuration please follow steps https://www.baeldung.com/lombok-ide
3.	Build ``` ./gradlew clean build ```
4.	Run the application by right click  ClusterApplication class
    OR using gradle command  ``` ./gradlew bootRun ```

### Endpoint Information
Swagger Documentation : http://localhost:8085/swagger-ui.html
- Health Check:
```
 create data points and clusters :
    GET -> http://localhost:8085/dataingest/heartbeat
    Headers -> "Content-Type":"application/json"
               "Accept-Charset":"UTF-8"
```
### Architecture flow for data-ingest-service
## ![data-ingest-service-logo](misc/Data-Pipeline-Arch.png)

### Jar file execution option 2 run application
 - Open command line prompt
 - Go to (cd to) project folder
 - Go to build/libs directory
 - execute command  ``` java -jar data-ingest-service.jar ```
 - http://localhost:8085/swagger-ui.html

### Docker Option 2 run application
 - To build docker image from docker file
   ``` docker build -t data-ingest-service .```
 - To run created docker image  ``` docker run -p 8085:8085 -t data-ingest-service ```
 - http://localhost:8085/swagger-ui.html

### Contribute
Ravi Reddy (Ravinder Nancherla)

### License
@CopyRight ( C ) All rights reserved to Ravi Reddy POC World. It's Illegal to reproduce this code.
[Ravi Reddy](https://www.linkedin.com/in/ravireddy55447/)
