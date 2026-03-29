# 🚀 Hibernate Learning Repository

This repository contains  **Hibernate ORM learning and practice**, covering core concepts, mappings, queries.

---

## 📌 What is Hibernate?

Hibernate is a **Java framework** that connects Java applications with databases using **ORM (Object Relational Mapping)**.

- Converts Java objects ↔ database tables  
- Reduces the need to write SQL  
- Handles CRUD operations automatically  
- Provides features like caching & lazy loading  

---

## 🔹 What is ORM?

ORM (Object Relational Mapping) is a technique to map:
- Java Classes → Database Tables  
- Variables → Columns  

👉 Helps avoid writing too much SQL code.

---

## 🔹 Hibernate vs JDBC

| Feature | JDBC | Hibernate |
|--------|------|----------|
| Level | Low-level | High-level |
| SQL | Manual | Auto-generated |
| Code | More | Less |
| Performance | Faster | Optimized with caching |
| Maintenance | Difficult | Easy |

👉 Hibernate internally uses JDBC.

---

## 🔹 What is JPA?

- JPA = **Java Persistence API**
- It is a **specification (rules)**, not implementation  
- Hibernate is an implementation of JPA  

👉 JPA = Guidelines  
👉 Hibernate = Tool implementing those guidelines  

---

 → Ignore field  

### Relationships:
- `@OneToOne`
- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`

---

## 🔹 Hibernate Core Concepts

### Session
- Represents connection with DB  
- Used for CRUD operations  

### SessionFactory
- Creates Session objects  
- Heavy-weight, created once  


## 🔹 Mapping Relationships

### 1️⃣ One-to-One
- One object ↔ one object  

### 2️⃣ One-to-Many
- One Programmer → Many Laptops  

### 3️⃣ Many-to-One
- Many Laptops → One Programmer  

### 4️⃣ Many-to-Many
- Many Programmers ↔ Many Laptops  

---

## 🔹 Fetch Types

| Type | Behavior |
|------|---------|
| EAGER | Load immediately |
| LAZY | Load when needed |

---

## 🔹 Hibernate Query Language (HQL)

- Works with **entities (classes)**, not tables  

### Example:
```sql
FROM Laptop
FROM Laptop WHERE ram = 32
```
👉 SQL → Table
👉 HQL → Class


## 🔹 get() vs load()
- Method	Behavior
- get()	Immediate DB hit, returns null
- load()	Lazy, returns proxy, throws exception
  
---
## 🔹 Lazy vs Eager Loading
### EAGER → loads all data immediately
### LAZY → loads data only when needed
- Lazy improves performance
---

## 🔹 Hibernate Caching
## 1️⃣ First-Level Cache
- Session-level
- Enabled by default
- Cleared when session closes

## 2️⃣ Second-Level Cache
- SessionFactory-level
- Shared across sessions
- Needs configuration (EhCache, etc.)

## 🔹 CRUD Operations
### Create
```js
session.save(obj);
session.persist(obj);
```
## Read
```js
session.get(Class, id);
session.load(Class, id);
```
## Update
```js
session.update(obj);
session.merge(obj);
```
## Delete
```js
session.delete(obj);
```

🛠️ Technologies Used
- Java
- Hibernate ORM
- Maven
- postgreSQL

