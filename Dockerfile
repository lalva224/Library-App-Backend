FROM maven AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn install -DskipTests

# For Java 17,
FROM openjdk:17-alpine

WORKDIR /opt/app
# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/*.jar /opt/app/
ENTRYPOINT ["java","-jar","admin-api-0.0.1-SNAPSHOT.jar"]