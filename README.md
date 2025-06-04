📚 Literalura

**Literalura** es una aplicación Java desarrollada con **Spring Boot** que permite consultar libros desde la API de [Gutendex](https://gutendex.com/), almacenarlos en una base de datos PostgreSQL y realizar consultas dinámicas sobre libros y autores.
---

Tecnologías utilizadas

- Java 17 o superior
- Spring Boot 3.4.x
- Spring Data JPA
- PostgreSQL 16
- HikariCP
- Maven
- API Gutendex (open data)

---

Funcionalidades

- ✅ Buscar libros por título usando Gutendex API
- ✅ Guardar libros y autores en la base de datos
- ✅ Listar todos los libros almacenados
- ✅ Buscar libros por idioma
- ✅ Listar todos los autores
- ✅ Listar autores vivos en un año dado

---

Modelo de datos

- **Libro**
  - Título
  - Idioma
  - Número de descargas
  - Autor (relación ManyToOne)

- **Autor**
  - Nombre
  - Año de nacimiento
  - Año de fallecimiento (nullable)

---

Menú interactivo 

Al ejecutar la aplicación, verás el siguiente menú:

📘 Menú Principal:
1 - Mostrar todos los libros
2 - Buscar libros por idioma
3 - Listar autores
4 - Buscar autores vivos en un año
5 - Salir
