# rails app

## build docker image
```bash
docker build -t rails_app .
```

## manually run database

```bash
docker run -e POSTGRES_PASSWORD=secure123 -e POSTGRES_USER=rails_user -e POSTGRES_DB=rails_app --name pg -d postgres
```
