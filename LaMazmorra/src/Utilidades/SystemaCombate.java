package Utilidades;

import Personajes.Enemigos.Enemigo;
import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

public class SystemaCombate {
    public static void Combate(Personaje jugador, Enemigo enemigo){
        System.out.println("⚔️ ¡Comienza el combate entre " + jugador.getNombre() + " y un " + enemigo.getNombre() + "! ⚔️");

        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
            // Turno del Guerrero
            int player = jugador.atacar() - enemigo.getDefensa();
            if (player < 0) player = 0;
            enemigo.setVida(enemigo.getVida() - player);
            System.out.println(jugador.getNombre() + " ataca y causa " + player + " de daño. (Vida restante del enemigo: " + enemigo.getVida() + ")");

            if (enemigo.getVida() <= 0) {
                System.out.println("💀 El " + enemigo.getNombre() + " ha sido derrotado. ¡Ganaste!");
                break;
            }

            // Turno del Enemigo
            int danioEnemigo = enemigo.atacar() - jugador.getDefensa();
            if (danioEnemigo < 0) danioEnemigo = 0;
            jugador.setVida(jugador.getVida() - danioEnemigo);
            System.out.println("El " + enemigo.getNombre() + " ataca y causa " + danioEnemigo + " de daño. (Vida restante del " + jugador.getNombre() + ": " + jugador.getVida() + ")");

            if (jugador.getVida() <= 0) {
                System.out.println("☠️ " + jugador.getNombre() + " ha sido derrotado. ¡Perdiste!");
                break;
            }
        }
    }
}