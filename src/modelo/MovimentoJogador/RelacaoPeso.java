package modelo.MovimentoJogador;

import modelo.tipos.Coordenada;

public class RelacaoPeso {
    private Coordenada destino;
    private int peso;

    public RelacaoPeso(Coordenada destino, int peso){
        this.destino = destino;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Coordenada getDestino() {
        return destino;
    }
    public void setDestino(Coordenada destino) {
        this.destino = destino;
    }

}
