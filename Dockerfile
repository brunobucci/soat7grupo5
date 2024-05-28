FROM ubuntu:24.04

WORKDIR /usr/local/

RUN apt update

RUN DEBIAN_FRONTEND=noninteractive TZ=Etc/UTC apt-get -y install tzdata

RUN apt install -y git && apt install -y maven && apt install -y openjdk-21-jdk

RUN git clone https://github.com/brunobucci/soat7grupo5.git

WORKDIR /usr/local/soat7grupo5

RUN git pull

RUN rm -rf target

RUN mvn clean install package

WORKDIR /usr/local/soat7grupo5/target/

# Expose the port the app runs in
EXPOSE 8080

CMD java -jar soat7grupo5-0.0.1-SNAPSHOT.jar