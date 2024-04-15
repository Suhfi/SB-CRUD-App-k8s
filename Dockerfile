FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD target/sb-crud-app.jar sb-crud-app.jar
ENTRYPOINT ["java","-jar","/sb-crud-app.jar"]