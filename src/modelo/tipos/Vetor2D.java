package modelo.tipos;

/**
 * Classe genérica Vetor2D que representa um vetor em duas dimensões (x, y).
 * Esta classe pode manipular diferentes tipos numéricos, como Integer, Double, etc.,
 * utilizando generics com a restrição de que o tipo T deve estender Number.
 *
 * @param <T> O tipo de dado para os componentes x e y do vetor (deve ser um subtipo de Number).
 */
public class Vetor2D<T extends Number> {

    // Atributos privados que representam as coordenadas x e y do vetor
    private T x;
    private T y;

    /**
     * Método getter para obter o valor da coordenada x.
     *
     * @return O valor atual de x.
     */
    public T getX() {
        return x;
    }

    /**
     * Método setter para definir o valor da coordenada x.
     *
     * @param x O novo valor de x.
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Método getter para obter o valor da coordenada y.
     *
     * @return O valor atual de y.
     */
    public T getY() {
        return y;
    }

    /**
     * Método setter para definir o valor da coordenada y.
     *
     * @param y O novo valor de y.
     */
    public void setY(T y) {
        this.y = y;
    }

    /**
     * Método toString que retorna uma representação em formato de String do vetor.
     * Este método facilita a visualização dos valores de x e y em formato legível.
     *
     * @return Uma String representando o vetor no formato "Vetor2D [x=value, y=value]".
     */
    @Override
    public String toString() {
        return "Vetor2D [x=" + x + ", y=" + y + "]";
    }
}
