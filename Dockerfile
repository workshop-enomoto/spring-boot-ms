#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -DskipTests -f /home/app/pom.xml clean package 

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/hellospringboot-0.0.1-SNAPSHOT.jar /usr/local/lib/hellospringboot-0.0.1-SNAPSHOT.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/usr/local/lib/hellospringboot-0.0.1-SNAPSHOT.jar"]


# FROM openjdk:8-jre-alpine
# ENV APP_FILE ms01-0.0.1-SNAPSHOT.jar
# ENV APP_HOME /usr/apps
# EXPOSE 80
# COPY target/$APP_FILE $APP_HOME/
# WORKDIR $APP_HOME
# ENTRYPOINT ["sh", "-c"]
# CMD ["exec java -jar $APP_FILE"]