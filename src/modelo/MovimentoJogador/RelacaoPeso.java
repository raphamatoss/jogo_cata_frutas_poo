package modelo.MovimentoJogador;

import modelo.tipos.Coordenada;

/**
 * Essa classe é responsável por abstrair os elementos do grafo do jogador.
 */
public class RelacaoPeso implements Comparable{
    /**
     * Coordenada correspondente ao peso.
     */
    private Coordenada coordenada;
    /**
     * Peso correspondente à coordenada.
     */
    private int peso;

    /**
     * O construtor recebe a coordenada e o peso e faz a atribuição.
     * @param coordenada Coordenada.
     * @param peso Peso.
     */
    public RelacaoPeso(Coordenada coordenada, int peso){
        this.coordenada = coordenada;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    public void setCoordenada(Coordenada destino) {
        this.coordenada = destino;
    }

    /**
     * A classe Relação peso implementa a interface Comparable. Portanto, exige o método compareTo.
     *
     * @param outraRelacao A relação a ser comparada.
     */
    @Override
    public int compareTo(Object outraRelacao) {
        // Compara o peso atual com o peso da outra relação
        return Integer.compare(this.peso,((RelacaoPeso) outraRelacao).getPeso());
    }
}
