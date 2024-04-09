FROM amazoncorretto:17
LABEL org.opencontainers.image.authors="gladsondevop"
#RUN mvn clean package -DskipTests
COPY ./target/contatos-0.0.1-SNAPSHOT.jar /home/contatos.jar
WORKDIR /home
ENTRYPOINT java -jar contatos.jar
EXPOSE 8080