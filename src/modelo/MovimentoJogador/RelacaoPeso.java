package modelo.MovimentoJogador;

import modelo.tipos.Coordenada;

public class RelacaoPeso {
    private Coordenada origem;
    private Coordenada destino;
    private int peso;

    public RelacaoPeso(Coordenada origem, Coordenada destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Coordenada getOrigem() {
        return origem;
    }
    public void setOrigem(Coordenada origem) {
        this.origem = origem;
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
