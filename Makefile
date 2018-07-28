stop:
	docker-compose -f docker-compose.yml stop -t 0

rm: stop
	docker-compose -f docker-compose.yml rm -fv

build: stop
	docker-compose -f docker-compose.yml build

deps:
	docker-compose -f docker-compose.yml up -d

metrics:
	rm -rf build
	gradle check jacocoTestReport sonar --no-build-cache  -q