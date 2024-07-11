# Etapa 1: Construcción
FROM maven:3.8.4-openjdk-17 AS build

# Configura el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y las dependencias de Maven
COPY pom.xml .

# Descarga las dependencias del proyecto
RUN mvn dependency:go-offline

# Copia el código fuente del proyecto
COPY src ./src

# Construye la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR desde la etapa de construcción
COPY --from=build /app/target/gfp-0.0.1-SNAPSHOT.jar /app/gfp-0.0.1-SNAPSHOT.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "gfp-0.0.1-SNAPSHOT.jar"]
