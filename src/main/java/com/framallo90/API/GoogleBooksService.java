package com.framallo90.API;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Clase que representa el servicio para interactuar con la API de Google Books
public class GoogleBooksService {
    // Cliente HTTP para realizar las solicitudes
    private final OkHttpClient httpClient;
    // Objeto Gson para manejar JSON
    private final Gson gson;

    // Constructor que inicializa el cliente HTTP y el objeto Gson
    public GoogleBooksService() {
        this.httpClient = new OkHttpClient();
        this.gson = new Gson();
    }

    // Método para buscar libros en Google Books
    public GoogleBooksResponse searchBooks(String query) throws IOException {
        // URL de la API de Google Books con la consulta de búsqueda
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        // Crear una solicitud HTTP GET
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Ejecutar la solicitud y obtener la respuesta
        try (Response response = httpClient.newCall(request).execute()) {
            // Verificar si la respuesta es exitosa
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Leer el cuerpo de la respuesta
            String responseBody = response.body().string();
            // Convertir el cuerpo de la respuesta JSON a un objeto GoogleBooksResponse
            return gson.fromJson(responseBody, GoogleBooksResponse.class);
        }
    }
}

// Clase que representa la respuesta de la API de Google Books
class GoogleBooksResponse {
    // Lista de elementos (libros) en la respuesta
    private List<Item> items;

    // Getter y setter para la lista de elementos
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

// Clase que representa un libro en la respuesta de la API de Google Books
class Item {
    // Información del volumen (libro)
    private VolumeInfo volumeInfo;

    // Getter y setter para la información del volumen
    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}

// Clase que representa la información del volumen (libro) en la API de Google Books
class VolumeInfo {
    // Título del libro
    private String title;
    // Lista de autores del libro
    private List<String> authors;
    // Descripción del libro
    private String description;
    // URL de la imagen de portada del libro
    private String thumbnail;
    // Precio del libro
    private double price;

    // Getters y setters para los campos de la información del volumen
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
