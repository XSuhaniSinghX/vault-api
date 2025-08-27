# 🔐 Vault – Secure Secret Management API

A lightweight **Spring Boot REST API** for secure secret storage, retrieval, and authentication.  

---

## 🚀 Features
- Store and retrieve secrets securely
- User registration and authentication
- MySQL database embedded inside the Docker image (self-contained deployment)
- CI/CD pipeline setup with **Jenkins** 
- Automated deployment using **Ansible** and **Docker Compose**
- Basic logging and encryption mechanisms

---

## 🛠️ Tech Stack
- **Language/Frameworks:** Java, Spring Boot  
- **Database:** MySQL  
- **DevOps Tools:** Docker, Jenkins, Ansible, GitHub Actions, Docker Compose  
- **Build Tools:** Maven

---

## 📂 Project Structure
```
vault-api/
 ├── src/               # Application source code
 ├── pom.xml            # Maven dependencies
 ├── Dockerfile         # Container setup
 ├── docker-compose.yml # Multi-service setup (optional)
 ├── ansible/           # Deployment playbooks
 └── README.md          # Documentation
```

---

## ⚡ Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/XSuhaniSinghX/Vault-API.git
cd Vault-API
```

### 2. Build and Run with Docker
```bash
docker build -t vault-api .
docker run -p 8080:8080 vault-api
```

### 3. API Endpoints
| Endpoint            | Method | Description                |
|---------------------|--------|----------------------------|
| `/auth/register`    | POST   | Register a new user        |
| `/auth/login`       | POST   | Authenticate and get token |
| `/secrets/{key}`    | GET    | Retrieve a stored secret   |
| `/secrets`          | POST   | Store a new secret         |

---

## 🔧 Deployment (CI/CD)
- Jenkins pipelines handle build and test automation.  
- Ansible playbooks configure servers and deploy containers.  
- Docker Compose enables local setup with API + MySQL.  

---

## 📌 Future Improvements
- Kubernetes-based deployment for scalability  
- Stronger secret encryption and key rotation  
- Advanced role-based access policies  

---
