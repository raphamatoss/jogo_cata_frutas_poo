package modelo.entidades;

import modelo.utils.Efeitos;

import java.util.ArrayList;

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

    /**
     * Retorna uma lista com os efeitos causados pelo consumo da fruta.
     *
     * Se a fruta estiver bichada, o efeito de envenenamento será adicionado.
     * Em todos os casos, o efeito neutro também será adicionado, indicando que a fruta
     * não possui efeitos adicionais além do envenenamento ou da falta dele.
     *
     * @return Uma lista com os efeitos causados pela fruta.
     */
    public ArrayList<Efeitos> causarEfeito(){
        ArrayList<Efeitos> efeitos = new ArrayList<>();
        if (this.bichada) efeitos.add(Efeitos.ENVENENAMENTO);
        efeitos.add(Efeitos.NEUTRO);
        return efeitos;
    }

    /**
     * Retorna uma representação em string do objeto Fruta.
     *
     * A representação em string é o nome da fruta.
     *
     * @return O nome da fruta.
     */
    @Override
    public String toString(){
        return this.nome;
    }

}
