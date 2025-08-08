# Gerenciamento de Perfis do GitHub API

Projeto em **Kotlin** com **Spring Boot 3** para gerenciamento de perfis do GitHub, utilizando **PostgreSQL** como banco de dados, **JPA/Hibernate** para persistência e **Flyway** para controle de versionamento do schema.

---

## 📋 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Java 17+](https://adoptium.net/)
- [Gradle 8+](https://gradle.org/install/) (ou usar o Gradle Wrapper `./gradlew`)
- [PostgreSQL 16+](https://www.postgresql.org/download/)
- Git

---

## ⚙️ Configuração do Banco de Dados

1. **Acessar o PostgreSQL como usuário administrador:**
```bash
sudo -u postgres psql

