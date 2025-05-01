package Utilidades;

import java.util.Random;

public class GenerarTesoro {
    public static Tesoro generarTesoroAleatorio() {
        Random random = new Random();
        int tipo = random.nextInt(3);

        switch (tipo) {
            case 0:
                return new Tesoro("Vial de Vida", "Vial", 50);
            case 1:
                return new Tesoro("Bolsa de Oro", "Oro", random.nextInt(50) + 10);
            case 2:
                return new Tesoro("Joya Antigua", "Valuable", random.nextInt(100) + 50);
            default:
                return new Tesoro("Piedra Misteriosa", "Valuable", 30);
        }
    }
}