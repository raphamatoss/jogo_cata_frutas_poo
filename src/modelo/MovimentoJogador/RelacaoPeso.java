package modelo.MovimentoJogador;

import modelo.tipos.Coordenada;

public class RelacaoPeso implements Comparable{
    private Coordenada coordenada;
    private int peso;

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


    @Override
    public int compareTo(Object outraRelacao) {
        // Compara o peso atual com o peso da outra relação
        return Integer.compare(this.peso,((RelacaoPeso) outraRelacao).getPeso());
    }
}
