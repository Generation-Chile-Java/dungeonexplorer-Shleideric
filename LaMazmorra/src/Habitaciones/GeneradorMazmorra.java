package Habitaciones;
import Personajes.Enemigos.Dragon;
import Personajes.Enemigos.Enemigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneradorMazmorra {
    public static List<Habitaciones> generarMazmorra() {
        List<Habitaciones> mazmorra = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int tipo = random.nextInt(3); // 0 = vacía, 1 = enemigo, 2 = tesoro

            switch (tipo) {
                case 0:
                    mazmorra.add(new Habitaciones(Tipo.VACIA, null, false));
                    break;
                case 1:
                    mazmorra.add(new Habitaciones(Tipo.ENEMIGO, Enemigo.generarEnemigoAlAzar(),false));
                    break;
                case 2:
                    mazmorra.add(new Habitaciones(Tipo.TESORO, null, false));
                    break;
            }
        }

        mazmorra.add(new Habitaciones(Tipo.LLAVE, null, false));

        mazmorra.add(new Habitaciones(Tipo.JEFE_FINAL, new Dragon(), false));

        Collections.shuffle(mazmorra.subList(0, 8));

        return mazmorra;
    }
}
