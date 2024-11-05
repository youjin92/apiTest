FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY build/libs/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]