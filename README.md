# Aaru Chalet

A Spring Boot-based Resort Management System demonstrating modern backend development practices, containerization, Kubernetes deployment, and CI/CD.

## Tech Stack

- Java 21
- Spring Boot
- Gradle
- Spring Data JPA
- MySQL 8.4
- Flyway
- Docker
- Docker Compose
- Kubernetes
- GitHub Actions (planned)
- Helm (planned)
- AWS EKS (planned)

---

## Features

- Customer Management
- Room Management
- Booking Management
- Flyway Database Migrations
- Spring Boot Actuator Health Checks
- Dockerized Application
- Kubernetes Deployment
- Persistent MySQL Storage
- ConfigMap-based Configuration

---

## Project Structure

```
aaru-chalet/
├── src/
├── k8s/
│   ├── configmap.yaml
│   ├── deployment.yaml
│   ├── service.yaml
│   ├── mysql-deployment.yaml
│   ├── mysql-service.yaml
│   └── mysql-pvc.yaml
├── Dockerfile
├── docker-compose.yml
├── build.gradle
├── Makefile
└── README.md
```

---

## Getting Started

### Clone Repository

```bash
git clone https://github.com/<your-username>/aaru-chalet.git
cd aaru-chalet
```

---

## Build

```bash
./gradlew clean build
```

---

## Run Locally

```bash
./gradlew bootRun
```

Application

```
http://localhost:8080
```

Health Endpoint

```
http://localhost:8080/actuator/health
```

---

## Docker

Build the Docker image

```bash
docker build -t aaru-chalet:1.0.3 .
```

Run using Docker Compose

```bash
docker compose up -d
```

---

## Kubernetes Deployment

Apply resources

```bash
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/mysql-pvc.yaml
kubectl apply -f k8s/mysql-deployment.yaml
kubectl apply -f k8s/mysql-service.yaml
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

Verify deployment

```bash
kubectl get all
```

View logs

```bash
kubectl logs deployment/aaru-chalet-deployment
```

---

## Configuration

Application configuration is externalized using Kubernetes ConfigMaps.

Example variables

- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_PROFILES_ACTIVE

Sensitive values such as database passwords should be stored in Kubernetes Secrets.

---

## Database

- MySQL 8.4
- Flyway Versioned Migrations
- Hibernate Validation (`ddl-auto=validate`)

---

## Health Checks

The application exposes Spring Boot Actuator endpoints used by Kubernetes.

- Startup Probe
- Readiness Probe
- Liveness Probe

Endpoint

```
/actuator/health
```

---

## Roadmap

- [x] Spring Boot Backend
- [x] MySQL Integration
- [x] Flyway Migrations
- [x] Docker Support
- [x] Docker Compose
- [x] Kubernetes Deployment
- [x] ConfigMaps
- [ ] Kubernetes Secrets
- [ ] Helm Charts
- [ ] Ingress Controller
- [ ] Horizontal Pod Autoscaler
- [ ] Prometheus & Grafana
- [ ] Centralized Logging
- [ ] GitHub Actions CI/CD
- [ ] AWS EKS Deployment

---

## License

This project is intended for learning and demonstration purposes.
