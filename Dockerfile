# Imagen base para compilar la aplicación
FROM gradle:8.13.0-jdk21 AS builder
WORKDIR /app

# Copiamos todo el contenido del proyecto
COPY . .

# Construimos el JAR (usamos bootJar que es lo común en Spring Boot)
RUN ./gradle bootJar --no-daemon

# 🐳 Paso 2: Imagen final ligera para ejecutar el JAR
FROM eclipse-temurin:21-jre

# Directorio donde vivirá la app en el contenedor
WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Puerto que expondrá la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
