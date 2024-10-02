package entidades;

import tipos.Coordenada;

public abstract class ElementoDinamico {
    private final Coordenada posicao;

    public ElementoDinamico(int x, int y) {
        posicao = new Coordenada(x, y);
    }

    // getters & setters --------------------------------
    // neste caso não existem setters pois quando instanciado
    // o objeto não muda a não ser que ele se mova.
    public int getPosicaoX() {
        return posicao.getX();
    }
    public int getPosicaoY() {
        return posicao.getY();
    }
    // --------------------------------------------------


    public void mover(int dx, int dy) {
        this.posicao.mover(dx, dy);
    }
}