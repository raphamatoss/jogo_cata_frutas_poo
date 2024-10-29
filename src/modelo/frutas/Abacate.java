package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;

/**
 * Representa uma fruta do tipo abacate.
 *
 * Esta classe estende a classe Fruta e define um abacate específico.
 * Um abacate pode estar bichado e causar efeitos diferentes ao ser consumido.
 */
public class Abacate extends Fruta {

    /**
     * Constrói um objeto Abacate.
     *
     * @param bichada Indica se o abacate está bichado.
     */
    public Abacate(boolean bichada) {
        super(bichada, "ab");
    }

    /**
     * Retorna uma lista com os efeitos causados pelo consumo do abacate.
     *
     * Se o abacate estiver bichado, o efeito de envenenamento será adicionado.
     * Em todos os casos, o efeito de aumento de força será adicionado.
     *
     * @return Uma lista com os efeitos causados pelo abacate.
     */
    @Override
    public ArrayList<Efeitos> causarEfeito() {

        ArrayList<Efeitos> efeitos = new ArrayList<>();
        if (this.isBichada()){
            efeitos.add(Efeitos.ENVENENAMENTO);
        }
        efeitos.add(Efeitos.FORCA);
        return efeitos;
    }
}
