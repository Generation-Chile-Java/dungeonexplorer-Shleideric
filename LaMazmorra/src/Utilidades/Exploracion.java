package Utilidades;

import Habitaciones.Habitaciones;
import Personajes.Personaje;

import java.util.List;
import java.util.Scanner;

public class Exploracion {
    private List<Habitaciones> mazmorra;
    private Personaje jugador;
    private boolean tieneLlave;
    private Scanner scanner;
    private Inventario inventario;

    public Exploracion(List<Habitaciones> mazmorra, Personaje jugador, boolean tieneLlave, Scanner scanner, Inventario inventario) {
        this.mazmorra = mazmorra;
        this.jugador = jugador;
        this.tieneLlave = tieneLlave;
        this.scanner = scanner;
        this.inventario = inventario;
    }

    public void explorar(){
        System.out.println("\n¡Tu aventura por la mazmorra comienza!");

        for (int i = 0; i < mazmorra.size(); i++) {
            Habitaciones habitaciones = mazmorra.get(i);
            System.out.println("\nLlegaste a una nueva habitación...");

            usarInventario();

        switch (habitaciones.getTipo()) {
            case VACIA:
                System.out.println("La habitación esta vacía.");
                break;

            case ENEMIGO:
                System.out.println("¡Un enemigo apareció!");
                SystemaCombate.Combate(jugador, habitaciones.getEnemigo());
                break;

            case TESORO:
                if (!habitaciones.isTesoroRecogido()) {
                    System.out.println("¡Encontraste un cofre de tesoro!");
                    recogerTesoro();
                    habitaciones.recogerTesoro();
                } else {
                    System.out.println("El tesoro ya fue recogido.");
                }
                break;

            case LLAVE:
                if (!habitaciones.isTesoroRecogido()) {
                    System.out.println("¡Encontraste la llave mágica!");
                    tieneLlave = true;
                    habitaciones.recogerTesoro();
                }
                break;

            case JEFE_FINAL:
                if (tieneLlave) {
                    System.out.println("¡Llegaste a la puerta del gran tesoro!");
                    System.out.println("¡Un dragón la protege!");
                    SystemaCombate.Combate(jugador, habitaciones.getEnemigo());
                    System.out.println("\n¡Has derrotado al dragón y reclamado el tesoro legendario!");
                } else {
                    System.out.println("La puerta del jefe está cerrada. ¡Necesitas la llave!");
                    System.out.println("Vuelve más tarde si la consigues.");
                }
                break;
            }
        }

        System.out.println("\n¡Gracias por explorar la mazmorra!");
    }

    private void recogerTesoro() {
        Tesoro tesoro = GenerarTesoro.generarTesoroAleatorio();
        System.out.println("¡Has encontrado: " + tesoro.getNombre() + "!");

        switch (tesoro.getTipo()) {
            case "Vial":
                inventario.agregarVial();
                break;
            case "Oro":
                jugador.agregarOro(tesoro.getCantidad());
                System.out.println("Obtienes " + tesoro.getCantidad() + " de oro.");
                break;
            case "Valuable":
                jugador.agregarValuable(tesoro.getNombre(), tesoro.getCantidad());
                System.out.println("Obtienes un objeto valioso: " + tesoro.getNombre());
                break;
        }
    }

    private void usarInventario() {
        System.out.println("¿Deseas usar un vial de vida? (s/n)");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("s")) {
            inventario.usarVial(jugador);
        }
    }
}
