MVN:=mvn
PROJECT_NAME?=observability-elk
BINARY:=./target/${PROJECT_NAME}-HEAD.jar
COLUMN:=:
dependencies:
	echo "runing dependencies ..."

package:
	${MVN} -Dmaven.test.skip=true package
clean:
	${MVN} clean

run:
	${MVN} spring-boot:run

