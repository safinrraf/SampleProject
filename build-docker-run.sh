#!/bin/bash

gradle clean bootJar

docker build --build-arg JAR_FILE=build/libs/\*.jar --tag safinrraf/sample_demo .

docker run --name SampleDemo --network=host -d -p 8080:8080 safinrraf/sample_demo