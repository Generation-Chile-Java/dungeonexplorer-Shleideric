package Personajes;

public class Personaje {
    protected String nombre;
    protected Integer vida;
    protected Integer fuerza;
    protected Integer inteligencia;
    protected Integer defensa;
    protected Integer posición = 0;

    //Constructor Completo
    public Personaje(String nombre, Integer vida, Integer fuerza, Integer inteligencia, Integer defensa, Integer posicion){
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.defensa = defensa;
        this.posición = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void atributos(){
        System.out.println(
                "----------------------------------" + "\n" +
                "nombre: " + this.nombre + "\n" +
                "vida: " + this.vida + "\n" +
                "fuerza: " + this.fuerza + "\n" +
                "inteligencia: " + this.inteligencia + "\n" +
                "defensa: " + this.defensa + "\n");
    }

    protected void Lvl(Integer vida, Integer fuerza, Integer defensa, Integer inteligencia){
        this.vida += vida;
        this.fuerza += fuerza;
        this.defensa += defensa;
        this.inteligencia += inteligencia;
    }

    private boolean estado(){
        return this.vida > 0;
    }
    private void muerte(){
        this.vida = 0;
        if (vida <= 0)
            System.out.println("Has Muerto");
    }

    protected int dano(Personaje enemigo){
        return Math.max(0 ,this.fuerza - enemigo.defensa);
    }

    protected void ataque(Personaje enemigo){
        Integer dano = this.dano(enemigo);
        enemigo.vida = Math.max(0, enemigo.vida - dano);
        if(enemigo.estado()){
            System.out.println("Vida enemigo: " + enemigo.vida);
        } else {
            enemigo.muerte();
        }
    }

    public int atacar(){
        return this.fuerza;
    }
}
