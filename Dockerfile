FROM maven:3.8.4-openjdk-21-slim AS build
COPY . C:/Users/carlo/agenda-compromisso-backend
RUN mvn -v
RUN mvn -f C:/Users/carlo/agenda-compromisso-backend/agenda/pom.xml clean package

#Step 2 - Run appointment-backend
FROM openjdk:21-slim
COPY --from=build C:/Users/carlo/agenda-compromisso-backend/agenda/target/*.jar C:/Users/carlo/agenda-compromisso-backend.jar
VOLUME /tmp
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "C:/Users/carlo/agenda-compromisso-backend.jar"]
