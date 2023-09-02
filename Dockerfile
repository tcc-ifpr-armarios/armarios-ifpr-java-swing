# Ainda em estudos

FROM maven:3.5.0-jdk-8
WORKDIR /apps
COPY . /apps
RUN mvn clean install -DskipTests
CMD tail -f /dev/null