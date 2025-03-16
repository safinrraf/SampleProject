#!/bin/bash

PROGRAM=${0##*/} # the version
VERSION="$PROGRAM v1.0.0"
LOG_TIME_FORMAT="%F %T"

BASE_DIR=.
DOCKER_COMPOSE_YML=$BASE_DIR/etc/docker-compose.yml

function lo3g() {
    local message=$1
    echo "$(date +"$LOG_TIME_FORMAT") $message"
}

function handle_error {
    lo3g "$(date +"$LOG_TIME_FORMAT") Caught an error with exit status $?"
}

source $BASE_DIR/etc/env.sh

lo3g "Start $VERSION"
lo3g "BASE_DIR.......$BASE_DIR"
lo3g "|"
lo3g "Gradle build"
gradle clean bootJar
lo3g "|"
lo3g "Docker login"
docker login -u $DOCKER_USER --password-stdin < ./docker_password.pswd
lo3g "|"
lo3g "Docker compose down"
docker compose -f $DOCKER_COMPOSE_YML down --volumes --rmi all
lo3g "|"
lo3g "Docker build"
docker build --build-arg JAR_FILE=build/libs/\*.jar --tag safinrraf/sample_demo .
lo3g "|"
lo3g "Docker compose up"
docker compose -f $DOCKER_COMPOSE_YML up -d

lo3g "End $VERSION"