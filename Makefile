default:
	cat ./Makefile
test:
	mvn test
dist:
	./mvnw clean package
run:
	docker-compose -f .deployment/docker-compose.yml up --build
up: dist run