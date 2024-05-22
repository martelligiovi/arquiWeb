FROM openjdk:21-jdk-slim
ARG JAR_FILE=demo/target/arquiWeb-0.0.1.jar
COPY ${JAR_FILE} app_arquiWeb.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app_arquiWeb.jar"]