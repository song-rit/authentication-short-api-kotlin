FROM adoptopenjdk/openjdk11:alpine-slim

RUN mkdir -p /app
ENV APP_HOME=/app
WORKDIR $APP_HOME

COPY build/libs/*SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT exec java -jar app.jar --spring.config.location=/app/config/application.yaml

