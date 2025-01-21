# Flavourful
---
### Overview
**Flavourful** is an online food shop application built using **Spring Boot** and **Java 21**. It supports ordering food, tracking delivery status, and sending updates to users at each step through **Kafka-based asynchronous communication**.

---

### Features
- **Food Ordering**: Browse and place food orders online.
- **Delivery Tracking**: Track delivery status in real-time.
- **Notifications**: Receive updates for each stage (order placed, prepared, dispatched, delivered).

---

### Architecture
- **Microservices**: Independent services for each feature.
- **Asynchronous Communication**: Kafka for scalability and responsiveness.
- **Tech Stack**:
  - **Backend**: Java 21, Spring Boot
  - **Messaging**: Apache Kafka
  - **Database**: PostgreSQL

---

### Prerequisites
- **Java 21** installed
- **Apache Kafka** configured and running
- **PostgreSQL** for database management
- **Maven/Gradle** for dependency management

---

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/workwithshivi/Flavourful.git
   cd flavourful
