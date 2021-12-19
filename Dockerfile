FROM openjdk:11-jdk-slim
VOLUME /app
EXPOSE 8080
ADD build/libs/simplebanking-0.0.1-SNAPSHOT.jar simplebanking-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","simplebanking-0.0.1-SNAPSHOT.jar" ]
