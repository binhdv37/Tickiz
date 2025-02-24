# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.6-alpine3.21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 8760

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]