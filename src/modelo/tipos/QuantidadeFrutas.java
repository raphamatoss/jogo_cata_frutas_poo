package modelo.tipos;
/**
 * Essa classe é auxiliar para guardar as informações da quantidade de frutas na árvore e na grama.
 */
public class QuantidadeFrutas {
    public int arvore;
    public int grama;

    /**
     * O construtor simplesmente recebe os valores de árvore e grama respectivamente.
     *
     * @param arvore Quantidade de arvores.
     * @param grama Quantidade de frutas na grama.
     */
    public QuantidadeFrutas(int arvore, int grama) {
        this.arvore = arvore;
        this.grama = grama;
    }
}
