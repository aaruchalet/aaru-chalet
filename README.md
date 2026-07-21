# 🏔️ Chalet Core

<p >
  <strong>A cloud-native Spring Boot backend for a Resort Management System demonstrating modern Java development, containerization, Kubernetes orchestration, and CI/CD using GitHub Actions and AWS.</strong>
</p>

<p >

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.x-02303A?style=for-the-badge&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)
![Helm](https://img.shields.io/badge/Helm-0F1689?style=for-the-badge&logo=helm)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions)
![AWS ECR](https://img.shields.io/badge/AWS-ECR-FF9900?style=for-the-badge&logo=amazonaws)

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
                  Helm Chart
                       │
                       ▼
          Amazon EKS Deployment (Next Phase)
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
- Kubernetes-ready Deployment using Helm
- Persistent MySQL Storage for Local Development
- Automated CI Pipeline with GitHub Actions
- Docker Image Publishing to Amazon ECR

---

# 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Build Tool | Gradle |
| Database | MySQL 8.4 |
| Database Migration | Flyway |
| Containerization | Docker |
| Orchestration | Kubernetes |
| Package Manager | Helm |
| CI | GitHub Actions |
| Container Registry | Amazon Elastic Container Registry (ECR) |
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
│   └── chalet-core/
│       ├── Chart.yaml
│       ├── values.yaml
│       └── templates/
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

# ☸️ Helm Deployment

The application is packaged and deployed using **Helm**, Kubernetes' package manager.

Install

```bash
helm install chalet-core ./helm/chalet-core
```

Upgrade

```bash
helm upgrade chalet-core ./helm/chalet-core
```

Verify

```bash
kubectl get pods

kubectl get deployments

kubectl get services
```

---

# 🔄 Continuous Integration Pipeline

Every push or pull request automatically performs:

- Checkout Repository
- Setup Java 21
- Gradle Build
- Build Docker Image
- Authenticate with AWS
- Login to Amazon ECR
- Tag Docker Image
- Push Docker Image to Amazon ECR

---

# 📦 Docker Images

Every Docker image is uniquely tagged using the Git commit SHA.

Example

```
712532372065.dkr.ecr.ap-south-1.amazonaws.com/chalet-core:<commit-sha>
```

This ensures every build is reproducible and traceable.

---

# 🗄️ Database

- MySQL 8.4
- Flyway Database Migrations
- Hibernate Validation (`ddl-auto=validate`)
- Persistent storage for local development using Docker Volumes and Kubernetes Persistent Volumes
- Production deployments can be configured to use an external database (e.g. Amazon RDS)

---

# 🩺 Health Checks

Spring Boot Actuator provides health endpoints for Kubernetes.

Endpoint

```
/actuator/health
```

Used for

- Startup Probe
- Readiness Probe
- Liveness Probe

---

# 🛣️ Roadmap

## ✅ Completed

- Spring Boot Backend
- REST APIs
- MySQL Integration
- Flyway Migrations
- Docker Support
- Docker Compose
- Kubernetes Setup
- Helm Charts
- GitHub Actions CI
- Amazon ECR Integration

## 🚧 In Progress

- Amazon EKS Deployment
- Helm-based Continuous Deployment (CD)

## 📌 Planned

- Kubernetes Secrets
- Ingress Controller
- Horizontal Pod Autoscaler (HPA)
- Prometheus Monitoring
- Grafana Dashboards
- Centralized Logging
- SonarQube Analysis
- Trivy Image Scanning
- Blue-Green / Rolling Deployments

---

# 📈 CI/CD Pipeline

```text
Developer
     │
     ▼
GitHub Repository
     │
     ▼
GitHub Actions
     │
     ├── Checkout
     ├── Gradle Build
     ├── Docker Build
     ├── AWS Authentication
     ├── Push Docker Image
     ▼
Amazon ECR
     │
     ▼
Helm
     │
     ▼
Amazon EKS (Next Phase)
```

---

# 👨‍💻 Author

**Manjeet Kumar**

GitHub: https://github.com/aaruchalet

---

# 📄 License

This project is intended for learning, experimentation, and demonstrating modern Java backend development and cloud-native DevOps practices.