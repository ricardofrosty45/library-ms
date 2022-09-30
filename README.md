# library-ms - Sample project - Open Source

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/ricardofrosty45/library-ms)

[![test](https://imgur.com/a/jQydM5X)](https://github.com/ricardofrosty45/library-ms)


This is a microservice, i've used Java with spring boot and mysql as a database. 
This API is a free open source code so you can study or clone and do whatever you want with it,there's no token validations whatsoever.
I've used the auth part into the front end so i can simplfy the project for begginers
If you want to run the full application with front end, you should see the project here

```sh
https://github.com/ricardofrosty45/library-app
```

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
