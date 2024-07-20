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
some how run MySql
SPRING_PROFILES_ACTIVE=local gradle clean build bootRun
```
### JAR
```
some how run MySql
gradle clean bootJar
java -Dspring.profiles.active=local -jar build/libs/adex-demo-0.0.1.jar
```
### Docker 
Approximate space required is 1.5Gb
```
./build-docker-run.sh   
```

## Check the manifest file
```
unzip -q -c build/libs/learn-java-1.0.0.jar  META-INF/MANIFEST.MF
```


## Viewing the Contents of a JAR File
[The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/deployment/jar/view.html)
```
jar tvf build/libs/learn-java-1.0.0.jar
```