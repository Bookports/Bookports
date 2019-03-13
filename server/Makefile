SHELL := /bin/sh

LEIN := lein
LEIN_OPTS :=

.POSIX:
.PHONY: all build clean ci test doc docker-build

all: clean build doc

build:
	${LEIN} ${LEIN_OPTS} compile

clean:
	${LEIN} ${LEIN_OPTS} clean

ci: clean build test

test:
	${LEIN} ${LEIN_OPTS} spec

docker-build:
	docker build -t shelves/server .

doc:
	+${MAKE} info -C ../doc
