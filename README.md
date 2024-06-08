# How to run project

### Modules
* adex-domain - API and models, domain logic
* adex-domain-impl - Implementation
* adex-rest - API and model, rest
* adex-rest-impl - Rest API implementation
* adex-jpa-impl - JPA implementation

### etc
* postman - Postman collection
* docker-compose.yml - to get MySQL up and running
* docker-entrypoint-initdb.d - initial DB script

### openapi-spec
* openapi_spec.yml - API specification

## How to run the project
### gradle
```
SPRING_PROFILES_ACTIVE=local gradle clean build bootRun
```
### JAR
```
gradle clean bootJar
java -Dspring.profiles.active=local -jar build/libs/adex-demo-0.0.1.jar
```
### Docker 
```
./build-docker-run.sh   
```