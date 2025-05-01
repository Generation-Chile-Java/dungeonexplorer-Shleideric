package Utilidades;

import Personajes.Personaje;

public class Inventario {
    private int vialesDeVida;

    public Inventario() {
        this.vialesDeVida = 3;
    }

    public void usarVial(Personaje personaje) {
        if (vialesDeVida > 0) {
            System.out.println("Usaste un vial de vida.");
            personaje.curar(50); // Cura 50 de vida
            vialesDeVida--;
        } else {
            System.out.println("¡No tienes viales de vida!");
        }
    }

    public void agregarVial() {
        vialesDeVida++;
        System.out.println("¡Encontraste un vial de vida!");
    }

    public int getVialesDeVida() {
        return vialesDeVida;
    }
}