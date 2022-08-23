FROM openjdk:11
WORKDIR /observability-elk
RUN apt update
RUN apt install maven -y
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
CMD ["mvn", "spring-boot:run"]