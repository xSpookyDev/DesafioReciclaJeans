package cl.desafio.service;

import cl.desafio.Producto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private ProductoServicio productoServicio;
    private ArchivoServicio archivoServicio;
    private Scanner scanner;

    public Menu() {
        this.productoServicio = new ProductoServicio();
        this.archivoServicio = new ArchivoServicio();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            try {
                System.out.println("1. Listar Producto");
                System.out.println("2. Editar Datos");
                System.out.println("3. Importar Datos");
                System.out.println("4. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        listarProductos();
                        break;
                    case 2:
                        editarDatos();
                        break;
                    case 3:
                        importarDatos();
                        break;
                    case 4:

                        Utilidad.tiempoEspera();
                        break;
                    default:
                        System.out.println("Opción no válida, ingrese un valor entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar opciones numéricas.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 4);
    }

    private void listarProductos() {
        productoServicio.listarProductos();
    }

    private void editarDatos() {
        productoServicio.editarProducto();
    }

    private void importarDatos() {
        String rutaArchivo = "src/Importaciones/ProductosImportados.csv";
        System.out.println("Cargar Datos");
        System.out.println("Ingresa la ruta en donde se encuentra el archivo ProductosImportados.csv: (escribir /src/Importaciones)");
        String rutaIngresada = scanner.nextLine();
        if ("/src/Importaciones".equals(rutaIngresada)) {
            List<Producto> productosCargados = archivoServicio.cargarDatos(rutaArchivo);
            productoServicio.setListaProductos((ArrayList<Producto>) productosCargados);
            System.out.println("\nDatos cargados correctamente en la lista.\n");
        } else {
            System.out.println("Ruta incorrecta, intente nuevamente.");
        }
    }
}
