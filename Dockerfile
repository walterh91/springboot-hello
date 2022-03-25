FROM openjdk:8
COPY target/demo-hello-0.0.1-SNAPSHOT.jar /target/app.jar
RUN mkdir /config
WORKDIR /target
ENTRYPOINT ["java","-jar","app.jar","--server.port=8080"]
