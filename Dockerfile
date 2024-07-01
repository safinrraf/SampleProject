#Thanks to https://spring.io/guides/gs/spring-boot-docker
FROM openjdk:21-jdk

WORKDIR /SampleDemo

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /SampleDemo/app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/SampleDemo/app.jar"]

#SPRING_PROFILES_ACTIVE=local gradle clean build bootRun
#or
#java -Dspring.profiles.active=local -jar build/libs/adex-demo-0.0.1.jar