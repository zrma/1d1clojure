VERSION = $(shell gobump show -r)
CURRENT_REVISION = $(shell git rev-parse --short HEAD)
BUILD_LDFLAGS = "-X github.com/zrma/clojure.revision=$(CURRENT_REVISION)"
ifdef update
  u=-u
endif

VENV ?= . env/bin/activate


.PHONY: test fmt lint all cover

test:
	lein test

fmt:
	lein cljfmt fix

lint:
	lein cljfmt check
	lein eastwood

all: fmt lint test

cover:
	lein cloverage
