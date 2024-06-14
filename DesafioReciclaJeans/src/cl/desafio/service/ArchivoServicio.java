package cl.desafio.service;

import cl.desafio.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoServicio {

    public List<Producto> cargarDatos(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        List<Producto> productos = new ArrayList<>();

        if (!archivo.exists() || !archivo.isFile()) {
            System.err.println("El archivo no existe o no es un archivo válido.");
            return productos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Producto producto = new Producto(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                    productos.add(producto);
                } else {
                    System.out.println("Línea con datos incompletos: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }

        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }

        return productos;
    }
}
