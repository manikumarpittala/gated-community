FROM mysql:8.4

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=gatedcommunity

EXPOSE 3306

COPY db_backup.sql docker-entrypoint-initdb.d/db_backup.sql
