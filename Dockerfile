FROM amazoncorretto:17
LABEL org.opencontainers.image.authors="gladsondevop"
COPY ./target/contatos-0.0.1-SNAPSHOT.jar /home/contatos.jar
WORKDIR /home
ENV DATASOURCE_URL=jdbc:mysql://localhost:30006/db_contatos?useTimezone=true&serverTimezone=America/Sao_Paulo
ENV DATASOURCE_USERNAME=contatos
ENV DATASOURCE_PASSWORD=123456
ENTRYPOINT java -jar contatos.jar
EXPOSE 8080

#RUN mvn clean package -DskipTests
#docker run --env DATASOURCE_URL='jdbc:mysql://10.100.36.239:30006/db_contatos?useTimezone=true&serverTimezone=America/Sao_Paulo' gladsondevop/contatos:2.0