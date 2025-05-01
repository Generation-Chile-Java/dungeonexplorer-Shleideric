package Habitaciones;

import Personajes.Enemigos.Enemigo;

public class Habitaciones {

    private Tipo tipo;
    private Enemigo enemigo;
    private boolean tesoroRecogido;

    // NUEVO: Conexiones
    private Habitaciones norte;
    private Habitaciones este;
    private Habitaciones oeste;

    // Constructor
    public Habitaciones(Tipo tipo, Enemigo enemigo) {
        this.tipo = tipo;
        this.enemigo = enemigo;
        this.tesoroRecogido = false;
    }

    // Métodos para conectar habitaciones
    public void conectarNorte(Habitaciones habitacion) {
        this.norte = habitacion;
    }

    public void conectarEste(Habitaciones habitacion) {
        this.este = habitacion;
    }

    public void conectarOeste(Habitaciones habitacion) {
        this.oeste = habitacion;
    }

    // Getters para moverse
    public Habitaciones getNorte() { return norte; }
    public Habitaciones getEste() { return este; }
    public Habitaciones getOeste() { return oeste; }


    public Habitaciones(Tipo tipo, Enemigo enemigo, boolean tesoroRecogido) {
        this.tipo = tipo;
        this.enemigo = enemigo;
        this.tesoroRecogido = tesoroRecogido;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public boolean isTesoroRecogido() {
        return tesoroRecogido;
    }

    public void recogerTesoro() {
        this.tesoroRecogido = true;
    }
}
