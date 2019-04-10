FROM tomcat:9.0.16-jre11-slim
COPY jar/ /usr/local/tomcat/lib
RUN apt-get update && apt-get install -y iputils-ping