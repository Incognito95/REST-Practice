FROM nginx:1.19.1-alpine

ADD nginx.conf /etc/nginx

RUN apk update && apk add bash
# Add this to the line above if you wan't nano: && apk add nano

# RUN sed '/^http {.*/a  client_max_body_size 50M;' /etc/nginx/nginx.conf
