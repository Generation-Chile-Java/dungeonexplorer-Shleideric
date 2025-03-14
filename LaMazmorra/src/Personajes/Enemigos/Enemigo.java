package Personajes.Enemigos;

import Personajes.Personaje;

import java.util.Random;

public class Enemigo extends Personaje {
    private Integer arma;

    public void setArma(int arma) {
        this.arma = arma;
    }

    public Enemigo(String nombre, Integer vida, Integer fuerza, Integer inteligencia, Integer defensa, Integer posicion, Integer arma) {
        super(nombre, vida, fuerza, inteligencia, defensa, posicion);
        this.arma = arma;
    }

    @Override
    public void atributos() {
        super.atributos();
        System.out.println(
                "arma: " + this.arma + "\n" +
                        "--------------------");
    }

    public static Enemigo generarEnemigoAlAzar() {
        Random random = new Random();
        int enemigoTipo = random.nextInt(4);

        switch (enemigoTipo) {
            case 0:
                return new Esqueleto();
            case 1:
                return new Zombie();
            case 2:
                return new Slime();
            case 3:
                return new Goblin();
            default:
                return new Esqueleto();
        }
    }
}



