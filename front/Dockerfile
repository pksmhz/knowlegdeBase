FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/app/app.jar
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]
