apt-get update
apt-get -y install nginx
systemctl status nginx
systemctl restart nginx
cat > /etc/nginx/sites-enabled/default << 'EOF'
upstream tomcat {
    server 127.0.0.1:8081 fail_timeout=0;
}

server {
        root /var/www/html;
        index index.html index.htm index.nginx-debian.html;

        server_name www.cphdat.dk edu.cphdat.dk;

        location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                # try_files $uri $uri/ =404;
                include proxy_params;
                proxy_pass http://tomcat/;
        }

    listen [::]:443 ssl ipv6only=on; # managed by Certbot
    listen 443 ssl; # managed by Certbot
    ssl_certificate /etc/letsencrypt/live/edu.cphdat.dk/fullchain.pem; # managed by Certbot
    ssl_certificate_key /etc/letsencrypt/live/edu.cphdat.dk/privkey.pem; # managed by Certbot
    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot
}

server {
    if ($host = www.cphdat.dk) {
        return 301 https://$host$request_uri;
    } # managed by Certbot


    if ($host = edu.cphdat.dk) {
        return 301 https://$host$request_uri;
    } # managed by Certbot


        listen 80 default_server;
        listen [::]:80 default_server;
 
        server_name www.cphdat.dk edu.cphdat.dk;
    return 404; # managed by Certbot
}
EOF
ufw disable
service nginx restart
snap install core
snap refresh core
snap install --classic certbot
ln -s /snap/bin/certbot /usr/bin/certbot
certbot --nginx
certbot renew --dry-run