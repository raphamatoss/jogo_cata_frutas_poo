package modelo.tipos;

/**
 * Essa classe define um equivalente à tuplas.
 */
public class Coordenada {
    
    /**
     * Linha i.
     */
    private int i;

    /**
     * Coluna j.
     */
    private int j;

    /**
     * O construtor recebe a linha e a coluna.
     *
     * @param i Linha.
     * @param j Coluna.
     */
    public Coordenada(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }
    
    public void setI(int i) {
        this.i = i;
    }
    
    public int getJ() {
        return j;
    }

    public void setJ(int y) {
        this.j = j;
    }


    public static Coordenada origem(){
        return new Coordenada(0,0);
    }
}
