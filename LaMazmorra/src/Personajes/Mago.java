package Personajes;
public class Mago extends Personaje {

    private  Integer libro;

    public Mago(String nombre, Integer vida, Integer fuerza, Integer inteligencia, Integer defensa, Integer libro){
        super(nombre,vida,fuerza,inteligencia,defensa,0);
        this.libro = libro;
    }

        @Override
        public void atributos() {
        super.atributos();
        System.out.println("Libro " + this.libro);
    }

        @Override
        protected int dano(Personaje enemigo) {
        return Math.max(0, this.inteligencia + libro - enemigo.defensa);
    }
}


