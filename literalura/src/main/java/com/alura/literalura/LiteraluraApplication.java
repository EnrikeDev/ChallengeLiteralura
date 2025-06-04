// LiteraluraApplication.java
package com.alura.literalura;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.service.AutorService;
import com.alura.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		System.out.println("\n📚 Bienvenido a LiterAlura\n");

		while (opcion != 5) {
			System.out.println("\n📖 Menú Principal:");
			System.out.println("1 - Mostrar todos los libros");
			System.out.println("2 - Buscar libros por idioma");
			System.out.println("3 - Listar autores");
			System.out.println("4 - Buscar autores vivos en un año");
			System.out.println("5 - Salir");
			System.out.print("Selecciona una opción: ");

			try {
				opcion = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("⚠️ Opcion inválida, intenta nuevamente.");
				continue;
			}

			switch (opcion) {
				case 1 -> {
					List<Libro> libros = libroService.obtenerTodos();
					if (libros.isEmpty()) {
						System.out.println("📭 No hay libros registrados.");
					} else {
						libros.forEach(System.out::println);
					}
				}
				case 2 -> {
					System.out.print("🌐 Ingresa el idioma (ej. 'en' para inglés, 'es' para español): ");
					String idioma = teclado.nextLine();
					List<Libro> librosPorIdioma = libroService.buscarPorIdioma(idioma);
					if (librosPorIdioma.isEmpty()) {
						System.out.println("❌ No se encontraron libros en ese idioma.");
					} else {
						librosPorIdioma.forEach(System.out::println);
					}
				}
				case 3 -> {
					List<Autor> autores = autorService.obtenerTodos();
					if (autores.isEmpty()) {
						System.out.println("📭 No hay autores registrados.");
					} else {
						autores.forEach(System.out::println);
					}
				}
				case 4 -> {
					System.out.print("📅 Ingresa el año para buscar autores vivos: ");
					try {
						int anio = Integer.parseInt(teclado.nextLine());
						List<Autor> autoresVivos = autorService.buscarAutoresVivosEnAnio(anio);
						if (autoresVivos.isEmpty()) {
							System.out.println("❌ No se encontraron autores vivos en el año " + anio + ".");
						} else {
							autoresVivos.forEach(System.out::println);
						}
					} catch (NumberFormatException e) {
						System.out.println("⚠️ Año inválido. Intenta de nuevo.");
					}
				}
				case 5 -> System.out.println("👋 Hasta luego.");
				default -> System.out.println("⚠️ Opcion inválida.");
			}
		}
	}
}
