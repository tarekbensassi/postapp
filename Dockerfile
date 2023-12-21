# Final Stage
#FROM openjdk:11
FROM openjdk:11-jre-slim
COPY target/*.jar app.jar
ENV PORT 8081
#EXPOSE $PORT
#ENTRYPOINT ["java", "-jar", "-Xmx1024M", "-Dserver.port=${PORT}", "app.jar"]
ENTRYPOINT ["java", "-jar", "-Xmx1024M", "app.jar"]