# Build stage:

FROM clojure:alpine AS builder

LABEL maintainer="Dom Rodriguez <shymega@shymega.org.uk>"

WORKDIR /tmp/build/bookports-server
COPY . /tmp/build/bookports-server

RUN lein with-profile production do deps, compile, uberjar, ring uberjar, ring uberwar

# Deployment stage:

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=builder \
    /tmp/build/bookports-server/target/uberjar/bookports-server-0.1.0-alpha-standalone.jar \
    /app/bookports-server-0.1.0-alpha-standalone.jar

CMD ["-help"]
ENTRYPOINT ["java", "-jar", "/app/bookports-server-0.1.0-alpha-standalone.jar"].
