package com.alura.literalura.service;

import com.alura.literalura.dto.LibroDTO;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    // Guarda lista de libros desde los DTO obtenidos de la API
    public void guardarLibros(List<LibroDTO> librosDTO) {
        for (LibroDTO dto : librosDTO) {
            Libro libro = convertirDTOaEntidad(dto);
            libroRepository.save(libro);
        }
    }

    // Convierte un LibroDTO a entidad Libro con su autor
    private Libro convertirDTOaEntidad(LibroDTO dto) {
        String idioma = dto.getLanguages().isEmpty() ? "desconocido" : dto.getLanguages().get(0);

        // Extraer primer autor
        var autorDTO = dto.getAutores().isEmpty() ? null : dto.getAutores().get(0);
        Autor autor = null;

        if (autorDTO != null) {
            // Verificar si el autor ya existe por nombre
            autor = autorRepository.findByNombre(autorDTO.getNombre())
                    .orElseGet(() -> {
                        Autor nuevoAutor = new Autor();
                        nuevoAutor.setNombre(autorDTO.getNombre());
                        nuevoAutor.setAnioNacimiento(autorDTO.getAnioNacimiento());
                        nuevoAutor.setAnioFallecimiento(autorDTO.getAnioFallecimiento());
                        return autorRepository.save(nuevoAutor);
                    });
        }

        return new Libro(
                dto.getTitle(),
                idioma,
                dto.getNumeroDeDescargas(),
                autor
        );
    }

    // Obtener todos los libros guardados
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    // Buscar libros por idioma (ignorando mayúsculas/minúsculas)
    public List<Libro> buscarPorIdioma(String idioma) {
        return libroRepository.findByIdiomaIgnoreCase(idioma);
    }
}
