# Build stage:

FROM clojure:alpine AS builder

LABEL maintainer="Dom Rodriguez <shymega@shymega.org.uk>"

WORKDIR /tmp/build/shelves-server
COPY . /tmp/build/shelves-server

RUN lein deps && \
    lein compile && \
    lein uberjar

# Deployment stage:

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=builder \
    /tmp/build/shelves-server/target/uberjar/shelves-server-0.1.0-alpha-standalone.jar \
    /app/shelves-server-0.1.0-alpha-standalone.jar

CMD ["-help"]
ENTRYPOINT ["java", "-jar", "/app/shelves-server-0.1.0-alpha-standalone.jar"].
