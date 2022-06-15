MVN:=mvn
PROJECT_NAME?=observability-elk
BINARY:=./target/${PROJECT_NAME}-HEAD.jar

dependencies:
	docker-compose up -d
package:
	${MVN} -Dmaven.test.skip=true package
clean:
	${MVN} clean

run:
	${MVN} spring-boot:run

