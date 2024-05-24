FROM ubuntu:20.04

WORKDIR /usr/local/

RUN apt update

RUN DEBIAN_FRONTEND=noninteractive TZ=Etc/UTC apt-get -y install tzdata

RUN apt install -y git && apt install -y maven && apt install -y openjdk-11-jre-headless

RUN git clone https://github.com/brunobucci/soat7grupo5.git

WORKDIR /usr/local/soat7grupo5

RUN git checkout homologacao

RUN mvn clean install package

WORKDIR /usr/local/tomcat/webapps/

RUN mv /usr/local/soat7grupo5/soat7grupo5.jar /usr/local/tomcat/webapps/

# Expose the port the app runs in
EXPOSE 8080

# Command to run the application
CMD ["catalina.sh", "run"]