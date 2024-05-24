FROM tomcat:8.5.13-alpine

#ARG ENVIRONMENT
 
#ENV ENVIRONMENT=$ENVIRONMENT

#RUN adduser fiap

#USER fiap

WORKDIR /usr/local/

# Clone the project from GitHub
#RUN apt-get update && apt-get install -y git
RUN apk update && apk add -y git

FROM maven:3.8.4-openjdk-11 AS build

RUN git clone https://github.com/brunobucci/soat7grupo5.git

WORKDIR /usr/local/soat7grupo5

RUN mvn dependency:go-offline

RUN mvn package

WORKDIR /usr/local/tomcat/webapps/

# Build and deploy the project
RUN mv /usr/local/soat7grupo5/soat7grupo5.jar /usr/local/tomcat/webapps/


# Expose the port the app runs in
EXPOSE 8080

# Command to run the application
CMD ["catalina.sh", "run"]