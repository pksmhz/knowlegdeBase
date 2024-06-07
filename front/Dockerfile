FROM eclipse-temurin:22-jre-alpine
RUN mkdir /opt/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/app/app.jar
ENTRYPOINT ["java","--enable-preview","-jar","/opt/app/app.jar"]
