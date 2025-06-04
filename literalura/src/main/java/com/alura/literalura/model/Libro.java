package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;

    @Column(name = "numero_de_descargas")
    private Integer numeroDeDescargas; // Cambiado de int a Integer

    @ManyToOne
    private Autor autor;

    public Libro() {}

    public Libro(String titulo, String idioma, Integer numeroDeDescargas, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
        this.autor = autor;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "📖 Libro: " + titulo + ", idioma: " + idioma + ", descargas: " + numeroDeDescargas +
                ", autor: " + (autor != null ? autor.getNombre() : "desconocido");
    }
}
