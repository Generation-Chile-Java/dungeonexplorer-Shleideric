import Habitaciones.GeneradorMazmorra;
import Habitaciones.Habitaciones;
import Utilidades.Exploracion;
import Utilidades.Inventario;
import Utilidades.SeleccionPersonaje;
import Utilidades.SystemaCombate;
import Personajes.Enemigos.Enemigo;
import Personajes.Personaje;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a La Mazmorra!");

        Personaje jugador = SeleccionPersonaje.prota();

        if (jugador != null) {
            System.out.println("\n¡Tu aventura comienza ahora!");
            Enemigo enemigo = Enemigo.generarEnemigoAlAzar();
            SystemaCombate.Combate(jugador, enemigo);

            List<Habitaciones> mazmorra = GeneradorMazmorra.generarMazmorra();

            Inventario inventario = new Inventario();

            Scanner scanner = new Scanner(System.in);

            Exploracion exploracion = new Exploracion(mazmorra,jugador,false, scanner, inventario);

            exploracion.explorar();
        } else {
            System.out.println("Hasta la próxima. ¡Adiós!");
        }
    }
}