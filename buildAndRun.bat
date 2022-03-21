@echo off
call mvn clean package
call docker build -t sn.maliki/galsenShop .
call docker rm -f galsenShop
call docker run -d -p 9080:9080 -p 9443:9443 --name galsenShop sn.maliki/galsenShop