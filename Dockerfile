# Use a base image with Java installed
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY build/libs/Entelgy_dummy_arqdig.jar .

# Set the command to run the application
CMD ["java", "-jar", "Entelgy_dummy_arqdig.jar"]


#Dockerfile modificado
