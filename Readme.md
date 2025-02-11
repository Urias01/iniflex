## Criação do banco de dados Postgres com Docker

```
docker run -d --name postgres-db \
  -e POSTGRES_DB=iniflex \
  -e POSTGRES_USER=root \
  -e POSTGRES_PASSWORD=root \
  -p 5432:5432 postgres:latest
```