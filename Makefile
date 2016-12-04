SHELL = /bin/sh

LEIN = lein
LEIN_OPTS =

all:
	${MAKE} build
	${MAKE} doc
	${MAKE} doc_info

build:
	${LEIN} ${LEIN_OPTS} compile

clean:
	${LEIN} ${LEIN_OPTS} clean

check:
	${MAKE} build
	${MAKE} test

test:
	${LEIN} ${LEIN_OPTS} spec

doc:
	${LEIN} ${LEIN_OPTS} codox

doc_info:
	cd doc/; \
	make info

.PHONY: all build clean check test bench doc doc_info

