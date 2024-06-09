#!/bin/bash

PROGRAM=${0##*/} # the version
VERSION="$PROGRAM v1.0.0"
LOG_TIME_FORMAT="%F %T"

BASE_DIR=~/programm/AdexDemo
DOCKER_COMPOSE_YML=$BASE_DIR/etc/docker-compose.yml

function loggging() {
    local message=$1
    echo "$(date +"$LOG_TIME_FORMAT") $message"
}

function handle_error {
    loggging "$(date +"$LOG_TIME_FORMAT") Caught an error with exit status $?"
}

source $BASE_DIR/etc/env.sh

loggging "Start $VERSION"
loggging "BASE_DIR.......$BASE_DIR"
loggging "|"
loggging "Gradle build"
gradle clean bootJar
loggging "|"
loggging "Docker login"
docker login -u $DOCKER_USER --password-stdin < ./docker_password.pswd
loggging "|"
loggging "Docker compose down"
docker compose -f $DOCKER_COMPOSE_YML down --volumes --rmi all
loggging "|"
loggging "Docker build"
docker build --build-arg JAR_FILE=build/libs/\*.jar --tag safinrraf/sample_demo .
loggging "|"
loggging "Docker compose up"
docker compose -f $DOCKER_COMPOSE_YML up -d

loggging "End $VERSION"