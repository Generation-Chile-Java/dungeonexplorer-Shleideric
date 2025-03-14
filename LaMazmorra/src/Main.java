import Utilidades.SeleccionPersonaje;
import Utilidades.SystemaCombate;
import Personajes.Enemigos.Enemigo;
import Personajes.Personaje;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a La Mazmorra!");

        Personaje jugador = SeleccionPersonaje.prota();

        if (jugador != null) {
            System.out.println("\n¡Tu aventura comienza ahora!");
            Enemigo enemigo = Enemigo.generarEnemigoAlAzar();
            SystemaCombate.Combate(jugador, enemigo);
        } else {
            System.out.println("Hasta la próxima. ¡Adiós!");
        }
    }
}