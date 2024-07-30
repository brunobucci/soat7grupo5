FROM mysql:8

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=soat7grupo5
ENV MYSQL_USER=soat7grupo5
ENV MYSQL_PASSWORD=soat7grupo5

COPY init.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["mysqld"]