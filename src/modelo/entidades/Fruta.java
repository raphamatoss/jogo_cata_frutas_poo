package modelo.entidades;

import javax.xml.namespace.QName;
/**
 * Essa classe implementa o comportamento abstrato das frutas do jogo.
 */
public abstract class Fruta {

    /**
     * Toda fruta tem a propriedade booleana de estar bichada ou não.
     */
    private boolean bichada;

    /**
     * O nome da fruta é implementado internamente apenas como identidade da fruta.
     */
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
