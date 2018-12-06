SHELL := /bin/sh

LEIN := lein
LEIN_OPTS :=

.POSIX:
.PHONY: all build clean check test doc

all: clean build doc

build:
	${LEIN} ${LEIN_OPTS} compile

clean:
	${LEIN} ${LEIN_OPTS} clean

ci: clean build test

test:
	${LEIN} ${LEIN_OPTS} spec

doc:
	${LEIN} ${LEIN_OPTS} codox
	+${MAKE} info -C doc
