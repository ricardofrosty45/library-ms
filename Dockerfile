FROM maven:3.6.3-openjdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:11.0.11-jdk-slim
COPY --from=build /home/app/target/library-ms-1.0.0-SNAPSHOT.jar library-ms-1.0.0-SNAPSHOT.jar

EXPOSE 8080
EXPOSE 3306

ENTRYPOINT ["java","-jar","library-ms-1.0.0-SNAPSHOT.jar"]