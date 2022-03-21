#!/bin/sh
mvn clean package && docker build -t sn.maliki/galsenShop .
docker rm -f galsenShop || true && docker run -d -p 9080:9080 -p 9443:9443 --name galsenShop sn.maliki/galsenShop