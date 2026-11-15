# 📅 Appointments API

CRUD REST API for appointments built with **Spring Boot 3**, containerized with Docker.
The web client is in [agenda-compromisso-frontend](https://github.com/carlosjc31/agenda-compromisso-frontend); the AWS deployment of the full stack is in [deploy-aws-agenda](https://github.com/carlosjc31/deploy-aws-agenda).

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

## Endpoints

| Method | Path | Description |
|---|---|---|
| `GET` | `/agenda` | list appointments |
| `GET` | `/agenda/{id}` | get one appointment |
| `POST` | `/agenda` | create |
| `PUT` | `/agenda/{id}` | update |
| `DELETE` | `/agenda/{id}` | delete |

## Architecture

`controller` → `service` → `repository` (Spring Data JPA), with request/response DTOs and a mapper. H2 database seeded by `data.sql`.
`docker-compose.yml` adds Nginx Proxy Manager as the reverse proxy.

## Run locally

```bash
./mvnw spring-boot:run
# or
docker compose up -d
```
