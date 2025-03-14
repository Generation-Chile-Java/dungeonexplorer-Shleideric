package Personajes;

public class Guerrero extends Personaje {
    private Integer espada;

    public Guerrero(String nombre, Integer vida, Integer fuerza, Integer inteligencia, Integer defensa, Integer espada){
        super(nombre,vida,fuerza,inteligencia,defensa,0);
        this.espada = espada;
    }

        @Override
        public void atributos() {
        super.atributos();
        System.out.println("espada: " + this.espada);
    }

        @Override
        protected int dano(Personaje enemigo) {
        return Math.max(0, this.fuerza + espada - enemigo.defensa);
    }
}
