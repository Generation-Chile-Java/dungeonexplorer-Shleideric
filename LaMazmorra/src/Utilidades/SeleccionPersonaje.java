package Utilidades;

import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeleccionPersonaje {
    public static void main(String[] args) {
        Scanner P1 = new Scanner(System.in);
        int clase = 0;
        while (true) {
            try {
                System.out.println("¿Con cual personaje quieres jugar? \n" +
                        "1. Personajes.Mago \n" +
                        "2. Personajes.Guerrero \n" +
                        "Elige una opción (1 o 2)");
                System.out.println("Indicame con cual personaje jugaras: ");
                clase = P1.nextInt();
            } catch (InputMismatchException r){
                System.out.println("Ya po");
                P1.next();
            } finally {
                if (clase == 1 || clase == 2) {
                    System.out.println("Ha elegido a su personaje");
                    P1.nextLine();
                    break;
                }
            }
        }

        Personaje jugador;

        System.out.print("Indica el nombre de tu personaje: ");
        String nombre = P1.nextLine();

        System.out.print("Cuántos puntos de vida tienes \n" +
                        "Debe indicar un valor entre 0 a 20 \n");
        int vida = 0;
        if(P1.hasNextInt()) {
            if (vida > 0 && vida <= 20) {
                vida = P1.nextInt();
                System.out.println(vida);
            } else {
                System.out.println("Usted ha indicado un numero fuera del rango recomendado");
            }
        }


        System.out.print("Cuánta fuerza tienes: ");
        int fuerza = P1.nextInt();

        System.out.print("Cuánta inteligencia tienes: ");
        int inteligencia = P1.nextInt();

        System.out.print("Cuánta defensa tienes: ");
        int defensa = P1.nextInt();

        if (clase == 1) {
            System.out.println("Usted ha indicado la clase Mago");
            System.out.println("Cuantos puntos tiene tu libro: ");
            int libro = P1.nextInt();
            jugador = new Mago(nombre, vida, fuerza, inteligencia, defensa, libro);

        } else if (clase == 2) {

            System.out.println("Usted ha indicado la clase Guerrero");
            System.out.println("Cuantos puntos tiene tu espada: ");
            int espada = P1.nextInt();
            jugador = new Guerrero(nombre, vida, fuerza, inteligencia, defensa, espada);
        } else {

            System.out.println("Usted no indico ninguna clase, personaje predeterminado");
            jugador = new Personaje(nombre, vida, fuerza, inteligencia, defensa, 0);
        }

        System.out.println("Estadisticas de Personajes.Personaje: ");
        jugador.atributos();


        P1.close();
    }
}
