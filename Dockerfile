FROM openjdk:17

WORKDIR /app

COPY build/libs/*.jar /app/veiculo-api.jar

EXPOSE 8080

CMD ["java", "-jar", "veiculo-api.jar"]