# Build stage:

FROM clojure:alpine AS build

LABEL maintainer="Dom Rodriguez <shymega@shymega.org.uk>"

WORKDIR /usr/src/emergence-server
COPY . /usr/src/emergence-server

RUN lein deps && \
    lein compile && \
    lein uberjar

# Deployment stage:

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=build \
    /usr/src/emergence-server/target/uberjar/emergence-server-standalone.jar \
    /app/emergence-server-standalone.jar

CMD ["java", "-jar", "/app/emergence-server-standalone.jar"].
