package Utilidades;

import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeleccionPersonaje {
    public static Personaje prota() {
        Scanner P1 = new Scanner(System.in);
        int clase;
        while (true) {
            System.out.println("¿Con cual personaje quieres jugar? \n" +
                    "1. Personajes Mago \n" +
                    "2. Personajes Guerrero \n" +
                    "3. Salir \n" +
                    "Elige una opción (1 o 2)");

            try {
                clase = P1.nextInt();

                switch (clase) {
                    case 1 -> {
                        System.out.println("Elegiste la clase Mago");
                        return atributosDist(P1, 1);
                    }
                    case 2 -> {
                        System.out.println("Elegiste la clase Guerrero");
                        return atributosDist(P1, 2);
                    }
                    case 3 -> {
                        System.out.println("Saliendo ...");
                        return null;
                    }
                    default -> System.out.println("Selecciona una opción");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                P1.next();
            }
        }
    }

    public static Personaje atributosDist(Scanner P1, int clase) {
        P1.nextLine();

        System.out.println("Es Hora de indicar tus atributos");
        System.out.print("Indica el nombre de tu personaje: ");
        String nombre = P1.nextLine();
        System.out.println( "|!----------------------RECOMENDACION---------------------!| \n" +
                "|----------Son un total de 4 estadísticas basicas----------| \n" +
                "|Lanza 4 veces un dado de 20 caras y organizalas a tu gusto| \n" +
                "|!--------------------------------------------------------!|");

        int vida = obtenerAtributo(P1, "vida");
        int fuerza = obtenerAtributo(P1, "fuerza");
        int inteligencia = obtenerAtributo(P1, "inteligencia");
        int defensa = obtenerAtributo(P1, "defensa");

        Personaje jugador;

        if (clase == 1) {
            System.out.println("Cuantos puntos tiene tu libro: ");
            int libro = P1.nextInt();
            jugador = new Mago(nombre, vida, fuerza, inteligencia, defensa, libro);
        } else {
            System.out.println("Cuantos puntos tiene tu espada: ");
            int espada = P1.nextInt();
            jugador = new Guerrero(nombre, vida, fuerza, inteligencia, defensa, espada);
        }

        System.out.println("Estadisticas de tu Personaje: ");
        jugador.atributos();

        return jugador;
    }

    private static int obtenerAtributo(Scanner P1, String atributo) {
        int valor;
        while (true) {
            System.out.printf("¿Cuántos puntos de %s tienes? (0-20): ", atributo);
            try {
                valor = P1.nextInt();
                if (valor >= 0 && valor <= 20) {
                    return valor;
                } else {
                    System.out.println("Error: El valor debe estar entre 0 y 20.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                P1.next(); // Limpiar la entrada incorrecta
            }
        }
    }
}