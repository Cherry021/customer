FROM maven as build
WORKDIR /app
RUN CD . . 
RUN mvn install

FROM openjdk:11 as base
WORKDIR /app
RUN CD --from=build /app/target/Customer-0.0.1-SNAPSHOT.jar .
EXPOSE 8089
CMD ["java","-jar","Customer-0.0.1-SNAPSHOT.jar"]
