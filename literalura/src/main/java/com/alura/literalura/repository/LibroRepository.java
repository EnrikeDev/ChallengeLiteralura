package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar libros por idioma, sin importar mayúsculas/minúsculas
    List<Libro> findByIdiomaIgnoreCase(String idioma);
}
