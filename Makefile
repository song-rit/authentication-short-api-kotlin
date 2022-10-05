docker_registry = credentials.docker_registry
docker_image = ${docker_registry}/authentication-short-version:latest

build-docker:
	docker build -t ${docker_image} .

push-docker:
    docker push ${docker_image}

build-app:
	./gradlew clean build -DskipTests

build-all: build-app build-docker push-docker

