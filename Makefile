VERSION = $(shell gobump show -r)
CURRENT_REVISION = $(shell git rev-parse --short HEAD)
BUILD_LDFLAGS = "-X github.com/zrma/clojure.revision=$(CURRENT_REVISION)"
ifdef update
  u=-u
endif

VENV ?= . env/bin/activate


.PHONY: fmt lint all cov cover

fmt:
	lein cljfmt fix

lint:
	lein cljfmt check
	lein eastwood
	lein kibit
	lein ancient

all: fmt lint cov

cov:
	lein cloverage

cover:
	lein cloverage --codecov --coveralls --lcov
