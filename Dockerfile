FROM openjdk:8-jdk-alpine
RUN apk update; apk add curl; apk add postgresql; apk add postgresql-contrib
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
ARG ARG_FILE=target/*.jar
COPY ${ARG_FILE} app.jar
COPY ./wait_db_start.sh /wait_db_start.sh
RUN chmod 755 /wait_db_start.sh
#CMD ["/wait_db_start.sh"]
ENTRYPOINT ["sh", "/wait_db_start.sh"]
#ENTRYPOINT ["/wait_db_start.sh"]
CMD ["echo", "!!!!!!!! Container_A is available now !!!!!!!!"]
#ENTRYPOINT ["java", "-jar", "/app.jar"]

#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java", "-cp", "app:app/lib/*", "play.spring.docker.DockerKafkaPostgresRedisApplication"]