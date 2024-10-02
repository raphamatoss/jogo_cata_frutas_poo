package modelo.entidades;

public abstract class Fruta {

    private boolean bichada;

    public Fruta(boolean bichada) {this.bichada = bichada;}


    // getters & setters ------------------------------
    public void bicharFruta() {
    	bichada=true;
    }

    public boolean isBichada() {
        return bichada;
    }
    public void setBichada(boolean bichada) {
        this.bichada = bichada;
    }
    // ------------------------------------------------


    public abstract void causarEfeito(); // TODO: Precisamos criar a lógica do causarEfeito()
}
