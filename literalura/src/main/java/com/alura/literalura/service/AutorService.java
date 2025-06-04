package com.alura.literalura.service;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void guardarAutor(AutorDTO dto) {
        Autor autor = new Autor(dto.getNombre(), dto.getAnioNacimiento(), dto.getAnioFallecimiento());
        autorRepository.save(autor);
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public List<Autor> buscarAutoresVivosEnAnio(Integer anio) {
        return autorRepository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqualOrAnioFallecimientoIsNull(
                anio, anio
        );
    }

}
