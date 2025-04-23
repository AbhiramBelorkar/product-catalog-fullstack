# Use OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set the JAR file location as an ARG
ARG JAR_FILE=target/*.jar

# Copy the jar file into the container
COPY ${JAR_FILE} app.jar

# Expose the port the app will run on
EXPOSE 8090

# Command to run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]