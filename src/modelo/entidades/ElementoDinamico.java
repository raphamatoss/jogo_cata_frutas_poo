package modelo.entidades;

import modelo.tipos.Coordenada;
/**
 * Essa classe serve de molde para o jogador e possivelmente para outros elementos que se movam.
 */
public abstract class ElementoDinamico {
    private Coordenada posicao;

    public ElementoDinamico(Coordenada coordenada) {
        posicao = coordenada;
    }

    // getters & setters --------------------------------
    // neste caso não existem setters pois quando instanciado
    // o objeto não muda a não ser que ele se mova.
    public Coordenada getCoordenada(){return this.posicao;}
    public void setCoordenada(Coordenada coordenada){this.posicao = coordenada;}
    public int getPosicaoX() {
        return posicao.getX();
    }
    public int getPosicaoY() {
        return posicao.getY();
    }
    // --------------------------------------------------


    /**
     * Reimplementa o método mover das coordenadas pelo sentido.
     */
    public void mover(int dx, int dy) {
        this.posicao.mover(dx, dy);
    }
}
