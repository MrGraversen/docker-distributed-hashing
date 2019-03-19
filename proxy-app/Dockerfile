FROM adoptopenjdk/openjdk11:alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]