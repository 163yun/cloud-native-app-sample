#!/usr/bin/env bash

# start neo4j docker container
function neo4j-docker() {
    docker run -d \
        --publish=7474:7474 \
        --volume=$HOME/neo4j/2.3/data:/data \
        --name=neo4j-2.3 \
        hub.c.163.com/bingohuang/neo4j:2.3


}

# change neo4j password
function neo4j-password() {
    curl -v -u neo4j:neo4j -X POST localhost:7474/user/neo4j/password -H 'Content-type:application/json' -d '{"password":"bingo"}'
}


function help() {
    echo "$0 neo4j|app"
}

if [ "$1" == "" ]; then
    help
elif [ "$1" == "neo4j-docker" ];then
    neo4j-docker
elif [ "$1" == "neo4j-password" ];then
    neo4j-password
elif [ "$1" == "app" ];then
    app
else
    help
fi