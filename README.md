# 🛡️ DevSecOps Labs — Master Portfolio

[![CI/CD](https://img.shields.io/badge/DevSecOps-S5%20Engineering-blue?style=for-the-badge)](.)
[![Python](https://img.shields.io/badge/Python-3.12%20%2F%203.13-3776AB?style=for-the-badge&logo=python&logoColor=white)](.)
[![Java](https://img.shields.io/badge/Java-17%2B%20%2F%2025-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](.)
[![Docker](https://img.shields.io/badge/Docker-Hardened%20Images-2496ED?style=for-the-badge&logo=docker&logoColor=white)](docker_lab/)
[![Trivy](https://img.shields.io/badge/Security-Trivy%20Scanned-13B5EA?style=for-the-badge)](docker_lab/)

Hands-on engineering laboratories completed for the **DevSecOps (Semester 5)** curriculum. This repository encompasses shift-left security practices across the entire software development lifecycle—ranging from test-driven development (TDD) quality gates, secure containerization, and vulnerability scanning, to continuous integration workflows.

---

## 📚 Laboratories & Modules Overview

| Module Directory | Topic & Scope | Technologies | Key Highlights & Deliverables |
|:---|:---|:---|:---|
| [**`week_1/`**](week_1/) | **Test-Driven Development (TDD) & Unit Testing** | Python 3.13 (`pytest`), Java 25 (`JUnit 5`), Maven | 121 automated unit tests across 6 core exercises covering edge cases, overflow safeguards, null safety, and data transformation with a 100% pass rate. |
| [**`docker_lab/`**](docker_lab/) | **From First Container to Secure Production Image** | Docker, Trivy, GitLab Container Registry | Container lifecycle, layer caching optimization, unprivileged `appuser` hardening (remediating DS-0002), vulnerability scanning, and versioned registry publishing (`1.1`). |
| [**`git_lab_devsecops/`**](git_lab_devsecops/) | **GitLab DevSecOps Workflows & Branching** | Git, GitLab, Branch Protection | Automated workflow practices, branch protection policies, and DevSecOps collaboration frameworks. |
| [**`jenkins_lab/`**](jenkins_lab/) | **Continuous Integration Automation** | Jenkins, CI/CD Pipelines | Automated build and test pipeline orchestration, quality gate enforcement, and artifact tracking. |

---

## 🎯 DevSecOps Philosophy: The Shift-Left Pipeline

```mermaid
flowchart LR
    A["🧪 1. Unit Tests & TDD<br/>(week_1)"] --> B["🐳 2. Containerization<br/>(docker_lab)"]
    B --> C["🔍 3. Security Scan<br/>(Trivy / SAST)"]
    C --> D["🚀 4. CI/CD Gate<br/>(Jenkins / GitLab)"]
    D --> E["📦 5. Registry & Deploy<br/>(Versioned 1.1)"]
```

1. **Shift-Left Quality (TDD)**: Catching logic errors and boundary defects before code reaches packaging ([`week_1`](week_1/)).
2. **Container Security**: Hardening base images, eliminating root execution, reducing attack surface ([`docker_lab`](docker_lab/)).
3. **Automated Scanning**: Continuous vulnerability scanning with Trivy.
4. **CI/CD Pipeline Gates**: Automated test and scan verification before build artifacts can be pushed or deployed.

---

## 👤 Author

- **Abdelbari Refak** ([@abdelbarirefak](https://github.com/abdelbarirefak))
- DevSecOps Engineering — S5
