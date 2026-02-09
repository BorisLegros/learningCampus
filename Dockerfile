# ==========================================
# Stage 1 : Build Frontend (Vue3)
# ==========================================
FROM node:20-alpine AS frontend-build
WORKDIR /app/frontend

# Copier package files et installer dépendances
COPY frontend/package*.json ./
RUN npm ci

# Copier le code source et builder
COPY frontend/ ./
RUN npm run build:prod

# ==========================================
# Stage 2 : Build Backend (Spring Boot)
# ==========================================
FROM maven:3.9-eclipse-temurin-17 AS backend-build
WORKDIR /app/backend

# Copier pom.xml et télécharger dépendances (cache layer)
COPY wacdo/pom.xml ./
RUN mvn dependency:go-offline -B

# Copier le code source
COPY wacdo/src ./src

# Copier les fichiers frontend buildés dans /static
COPY --from=frontend-build /app/frontend/dist ./src/main/resources/static

# Builder le JAR
RUN mvn clean package -DskipTests

# ==========================================
# Stage 3 : Image finale (Runtime)
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR depuis le build
COPY --from=backend-build /app/backend/target/*.jar app.jar

# Exposer le port
EXPOSE 8080

# Démarrer l'application
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]