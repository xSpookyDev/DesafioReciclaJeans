package cl.desafio.service;

public class Utilidad {
    public static void tiempoEspera() {
        try {
            System.out.println("Abandonando el sistema de clientes...");
            Thread.sleep(3000);
            System.out.println("Acaba de salir del sistema");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
