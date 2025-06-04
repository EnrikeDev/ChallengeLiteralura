package com.alura.literalura;

import com.alura.literalura.dto.LibroDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class ApiCliente {

    private final String BASE_URL = "https://gutendex.com/books/";

    // Método 1: Obtener lista inicial de libros
    public List<LibroDTO> obtenerLibros() {
        return realizarConsulta(BASE_URL);
    }

    // Método 2: Buscar libros por título
    public List<LibroDTO> buscarLibroPorTitulo(String titulo) {
        String urlConBusqueda = BASE_URL + "?search=" + titulo.replace(" ", "%20");
        return realizarConsulta(urlConBusqueda);
    }

    // Método reutilizado para hacer peticiones y mapear JSON
    private List<LibroDTO> realizarConsulta(String url) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode raiz = mapper.readTree(response.body());
            JsonNode resultados = raiz.path("results");

            LibroDTO[] libros = mapper.readValue(resultados.toString(), LibroDTO[].class);
            return Arrays.asList(libros);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("❌ Error al consultar la API: " + url, e);
        }
    }
}
