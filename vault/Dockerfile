# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy only pom first to leverage Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the rest of the source
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# ---- Runtime Stage ----
FROM eclipse-temurin:17-jdk AS runtime
WORKDIR /app

# Copy the JAR built from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
