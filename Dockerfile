# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/ecommerce-0.0.1-SNAPSHOT.jar ecommerce.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "ecommerce.jar"]