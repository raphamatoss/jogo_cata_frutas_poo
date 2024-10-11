package modelo.tipos;

/**
 * Essa classe define um equivalente à tuplas.
 */
public class Coordenada {
    
    /**
     * Componente x.
     */
    private int x;

    /**
     * Componente y.
     */
    private int y;

    /**
     * O construtor recebe as coordenadas x e y.
     *
     * @param x Componente x.
     * @param y Componente y.
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Mover é o método que é utilizado para modificar as coordenadas dinamicamente.
     *
     * @param dx Variação em dx.
     * @param dy Variação em dy.
     */
    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
