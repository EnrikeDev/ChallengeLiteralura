package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

    // Autores vivos en un año específico o aún vivos (anioFallecimiento es null)
    List<Autor> findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqualOrAnioFallecimientoIsNull(
            Integer nacimiento,
            Integer fallecimiento
    );

}
