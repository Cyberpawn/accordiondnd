FROM nginx
COPY nginx-config/ /etc/nginx/
WORKDIR /etc/nginx/
RUN apt-get update && apt-get install vim -y && apt-get install -y iputils-ping && mkdir logs