# 🏔️ Chalet Core

<p align="center">
  <strong>A cloud-native Spring Boot backend for Resort Management demonstrating modern Java development, containerization, Kubernetes orchestration, and CI/CD with GitHub Actions & AWS.</strong>
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.x-02303A?style=for-the-badge&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions)
![AWS](https://img.shields.io/badge/AWS-ECR-FF9900?style=for-the-badge&logo=amazonaws)

</p>

---

# 🏗️ Architecture

```text
                           Developer
                               │
                               ▼
                    GitHub Repository
                               │
                               ▼
                     GitHub Actions CI
                               │
        ┌──────────────────────┼──────────────────────┐
        │                      │                      │
        ▼                      ▼                      ▼
  Gradle Build          Docker Build        AWS Authentication
        │                      │                      │
        └──────────────┬───────┴──────────────────────┘
                       ▼
                 Amazon ECR Registry
                       │
                       ▼
            Kubernetes Cluster (Planned)
                       │
                       ▼
              Spring Boot Application
                       │
                       ▼
                     MySQL
```

---

# 🚀 Features

- Customer Management
- Room Management
- Booking Management
- REST APIs
- Spring Security
- Flyway Database Migrations
- Spring Boot Actuator
- Dockerized Application
- Kubernetes Deployment
- Persistent MySQL Storage
- ConfigMap-based Configuration
- GitHub Actions CI
- Amazon ECR Integration

---

# 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Build Tool | Gradle |
| Database | MySQL 8.4 |
| Migration | Flyway |
| Containerization | Docker |
| Orchestration | Kubernetes |
| CI | GitHub Actions |
| Container Registry | Amazon ECR |
| Deployment | Helm *(In Progress)* |
| Cloud | AWS |

---

# 📁 Project Structure

```text
chalet-core/
├── src/
│   ├── main/
│   └── test/
│
├── helm/
│
├── k8s/
│   ├── configmap.yaml
│   ├── deployment.yaml
│   ├── service.yaml
│   ├── mysql-deployment.yaml
│   ├── mysql-service.yaml
│   └── mysql-pvc.yaml
│
├── .github/
│   └── workflows/
│       ├── gradle-ci.yml
│       └── aws-auth.yml
│
├── Dockerfile
├── docker-compose.yml
├── build.gradle
├── Makefile
└── README.md
```

---

# ⚙️ Getting Started

## Clone Repository

```bash
git clone https://github.com/aaruchalet/chalet-core.git

cd chalet-core
```

---

## Build

```bash
./gradlew clean build
```

---

## Run

```bash
./gradlew bootRun
```

Application

```
http://localhost:8080
```

Health Check

```
http://localhost:8080/actuator/health
```

---

# 🐳 Docker

Build

```bash
docker build -t chalet-core .
```

Run

```bash
docker compose up -d
```

---

# ☸️ Kubernetes

Deploy

```bash
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/mysql-pvc.yaml
kubectl apply -f k8s/mysql-deployment.yaml
kubectl apply -f k8s/mysql-service.yaml
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

Verify

```bash
kubectl get all
```

Logs

```bash
kubectl logs deployment/chalet-core-deployment
```

---

# 🔄 CI Pipeline

```text
Git Push / Pull Request
            │
            ▼
      Checkout Source
            │
            ▼
      Setup Java 21
            │
            ▼
      Gradle Build
            │
            ▼
      Docker Build
            │
            ▼
 AWS Authentication
            │
            ▼
 Login to Amazon ECR
            │
            ▼
 Docker Image Push
            │
            ▼
 Amazon Elastic Container Registry
```

---

# 📦 Docker Images

Each Docker image is tagged with the Git commit SHA.

Example

```
712532372065.dkr.ecr.ap-south-1.amazonaws.com/chalet-core:<commit-sha>
```

---

# 🩺 Health Checks

Spring Boot Actuator endpoints

```
/actuator/health
```

Used for

- Startup Probe
- Readiness Probe
- Liveness Probe

---

# 🗺️ Roadmap

## Completed

- ✅ Spring Boot Backend
- ✅ REST APIs
- ✅ MySQL Integration
- ✅ Flyway Migrations
- ✅ Docker
- ✅ Docker Compose
- ✅ Kubernetes
- ✅ ConfigMaps
- ✅ GitHub Actions CI
- ✅ Amazon ECR Integration

## Upcoming

- ⏳ Kubernetes Secrets
- ⏳ Helm Charts
- ⏳ Amazon EKS Deployment
- ⏳ Ingress Controller
- ⏳ Horizontal Pod Autoscaler
- ⏳ Prometheus
- ⏳ Grafana
- ⏳ Centralized Logging
- ⏳ SonarQube
- ⏳ Trivy Security Scanning

---

# 📈 Future CI/CD Pipeline

```text
Developer
     │
     ▼
GitHub Repository
     │
     ▼
GitHub Actions
     │
     ▼
Gradle Build
     │
     ▼
Docker Build
     │
     ▼
Amazon ECR
     │
     ▼
Amazon EKS
     │
     ▼
Helm Upgrade
     │
     ▼
Rolling Deployment
     │
     ▼
Live Application
```

---

# 👨‍💻 Author

**Manjeet Kumar**

GitHub: https://github.com/aaruchalet

---

# 📄 License

This project is intended for learning, experimentation, and demonstrating modern Java backend development and cloud-native DevOps practices.
