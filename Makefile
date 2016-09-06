SHELL = /bin/sh

LEIN = lein
LEIN_OPTS =

BOOTSTRAP = script/bootstrap
BOOTSTRAP_OPTS =

CIBUILD = script/cibuild
CIBUILD_OPTS =

AFTER_CIBUILD = script/after_cibuild
AFTER_CIBUILD_OPTS =

after_cibuild:
	${AFTER_CIBULD} ${AFTER_CIBULD_OPTS}

all:
	${MAKE} build
	${MAKE} doc
	${MAKE} doc_info

build:
	${LEIN} ${LEIN_OPTS} compile

bootstrap:
	${BOOTSTRAP} ${BOOTSTRAP_OPTS}

cibuild:
	${CIBUILD} ${CIBUILD_OPTS}

clean:
	${LEIN} ${LEIN_OPTS} clean

check:
	${MAKE} build
	${MAKE} test

test:
	${LEIN} ${LEIN_OPTS} spec

doc:
	${LEIN}${LEIN_OPTS} doc

doc_info:
	cd docs/; \
	make info

.PHONY: all build clean check test bench doc doc_info

