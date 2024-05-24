FROM mysql:latest 

WORKDIR /usr/local/

# Clone the project from GitHub
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/efsavage/hello-world-war.git

WORKDIR /usr/local/tomcat/webapps/

# Build and deploy the project
RUN mv /usr/local/hello-world-war/dist/hello-world.war /usr/local/tomcat/webapps/

# Expose the port the app runs in
EXPOSE 8080

# Command to run the application
CMD ["catalina.sh", "run"]