package modelo.entidades;

import javax.xml.namespace.QName;

public abstract class Fruta {

    private boolean bichada;
    private String nome;

    public Fruta(boolean bichada, String nome) {
        this.bichada = bichada;
        this.nome = nome;
    }


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

    @Override
    public String toString(){
        return this.nome;
    }

}
