# JR-final-training-db-project 🎓

A Java Rush educational project created as part of a training course. **Most of the code was rewritten from the assignment**, the goal was to practice connecting **Java ↔ Hibernate ↔ MySQL ↔ Redis** and get hands-on with **Docker**.

## ✨ Features

* 💻 **Java (console/standalone)** — main application logic.
* 🗃 **Hibernate (ORM)** — entity mapping and CRUD operations.
* 🐬 **MySQL** — relational database.
* ⚡ **Redis** — cache and performance benchmark against MySQL.
* 📦 **Docker** — quick setup of MySQL/Redis (without docker-compose).
* 🗄 **SQL dump** — ready-to-use schema/data in `src/main/resources/sql/dump-hibernate-final.sql`.

## 🚀 Getting Started

1. **Clone the repository**

```bash
git clone https://github.com/CrapMind/JR-final-training-db-project.git
cd JR-final-training-db-project
```

2. **Run MySQL and Redis with Docker**

```bash
# MySQL (set your own user/password; adjust port if needed)
docker run --name jr-mysql -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=jrdb -p 3306:3306 -d mysql:8

# Redis
docker run --name jr-redis -p 6379:6379 -d redis:7
```

3. **Import the SQL dump**

```bash
docker cp src/main/resources/sql/dump-hibernate-final.sql jr-mysql:/dump.sql
docker exec -it jr-mysql mysql -uroot -ppass jrdb < /dump.sql
```

4. **Run the project**
   Run the main class `dev.subotinov.util.Main` from your IDE. All configuration for Hibernate is set directly in code inside this class.

## ⚡ Redis in the Project

* Used as a **cache** and/or **benchmark**: compare query performance vs MySQL.
* Default connection: `localhost:6379` (adjust in config/classes if needed).

## 📂 Project Structure

```
src/main/java/dev/subotinov/
  dao/        — data access objects (DAOs for entities)
  domain/     — entity classes mapped with Hibernate
  redis/      — Redis cache helpers and integration
  util/       — utility classes, includes Main entry point
src/main/resources/
  sql/              — SQL dump and scripts
    dump-hibernate-final.sql
  spy.properties    — SQL logging config (P6Spy)
pom.xml — Maven build file
Dockerfile (if present)
```

## 🧪 How to Test

* Run the main class (`Main`). It contains two simple methods:

  * `testMySQLData` — fetches data from MySQL.
  * `testRedisData` — fetches data from Redis.
* In the `main` method, the execution time of these two approaches is measured and compared directly.

## 🎓 Why This Repository is Educational

* The code **follows the assignment**, without advanced architecture decisions.
* The purpose is to **learn environment setup**, connect different technologies, and practice CRUD/cache operations.

## 🚧 Possible Improvements

* Add **logging** (SLF4J/Logback).
* Externalize configs into **.env** and inject into Docker.
* Add **integration tests** (Testcontainers for MySQL/Redis).
* Improve **transaction management** (utility wrappers for `Transaction`).
