package Utilidades;

public class Util {
    public static int clamp(int valor, int min, int max){
        return Math.max(min,Math.min(valor,max));
    }
}
