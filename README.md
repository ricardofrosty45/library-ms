# library-ms - AXIANS Test Project

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/ricardofrosty45/library-ms)

this microservice was a test by AXIANS, where i've got challenged to make not only the back end but also the front end using Spring boot + Java + ReactJs

## Features

- MySql
- Docker for local runs and local tests
- API Documentation
- Unit tests were implemented


## How to run it
First you need to have docker installed on your pc, here's a link

```sh
https://www.docker.com/products/docker-desktop
```

If you want to read my api documentation, here's the URL after you run the docker-compose file


```sh
http://localhost:8080/swagger-ui/index.html?configUrl=/docs.json/swagger-config#/
```
After install docker on your pc, you should build the project first into the container.
You should run the command

```sh
docker-compose build
```
It will take a while to build the project because of project's dependencies.
After it, you should run the command

```sh
docker-compose up
```

It will automatically build a mysql container and this microservice container and it's good to run now!


## DEV Annotations

- First of all, i've created a admin / user entity builder, when you start the application it should autoamtically create new users and admin's.their "names" are random names they're random generated. Every name is unique in this database

- I've used on the front end a auth, it's called firebase.