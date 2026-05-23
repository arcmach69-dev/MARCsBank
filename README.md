# MARCsBank — Digital Banking Platform

A production-grade digital banking platform built with microservices architecture.

## Services
- **User Service** — Registration, Login, JWT, OAuth 2.0
- **Account Service** — Account management, balances
- **Transaction Service** — Real-time transfers, Kafka events
- **Loan Service** — Apply, approve, Spring Batch processing
- **Fraud Detection** — Kafka consumer, Lambda, MongoDB
- **Notification Service** — AWS SNS, SQS, email/SMS
- **Investment Service** — GraphQL, MongoDB
- **KYC Service** — Document upload, S3, MongoDB

## Tech Stack
Java 17 | Spring Boot 3.x | Spring Cloud Gateway | Apache Kafka | RabbitMQ
PostgreSQL | MongoDB | Redis | DynamoDB | React.js v18 | TypeScript | Redux
AWS (EC2, EKS, Lambda, S3, RDS, SNS, SQS) | Docker | Kubernetes | Helm | Terraform
Jenkins | GitHub Actions | SonarQube | ELK Stack | Grafana | New Relic | Splunk
JUnit 5 | Mockito | Testcontainers | Cypress | Selenium

## Quick Start
```bash
docker-compose up -d
```
