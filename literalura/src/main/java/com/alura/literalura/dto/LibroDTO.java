package com.alura.literalura.dto;
import com.alura.literalura.dto.AutorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {

    private String title;

    @JsonProperty("authors")
    private List<AutorDTO> autores;

    private List<String> languages;

    @JsonProperty("download_count")
    private int numeroDeDescargas;

    // Getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(int numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro: " + title +
                ", Idiomas: " + languages +
                ", Descargas: " + numeroDeDescargas +
                ", Autores: " + autores;
    }
}
