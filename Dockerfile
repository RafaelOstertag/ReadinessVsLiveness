FROM openjdk:jre-slim

ADD target/*.jar /app/app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app/app.jar"]