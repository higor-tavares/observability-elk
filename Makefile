MVN:=mvn

dependencies:
	docker-compose up -d
run:
	${MVN} spring-boot:run
clean:
	docker-compose down
	${MVN} clean

