FROM openjdk:17

WORKDIR /app

COPY build/libs/*.jar /app/veiculo-api.jar

EXPOSE 8081

CMD ["java", "-jar", "veiculo-api.jar"]