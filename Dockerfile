FROM openjdk:21-oracle

WORKDIR /app

COPY build/libs/student-registration-0.0.1-SNAPSHOT.jar app.jar

ENV AUTOFILLING=false

CMD ["java", "-jar", "app.jar"]