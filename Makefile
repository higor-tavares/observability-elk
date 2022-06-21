MVN:=mvn
APPLICATION:=observability-api

build:
	docker build -t ${APPLICATION} .
dependencies:
	docker-compose up -d
run:
	docker run -p 8080:8080 --network=observability-elk_internal --name=${APPLICATION} ${APPLICATION}
clean:
	docker container stop ${APPLICATION}
	docker-compose down
	${MVN} clean

