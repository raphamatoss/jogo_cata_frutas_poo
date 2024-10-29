package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;

/**
 * Representa uma fruta do tipo laranja.
 *
 * Esta classe estende a classe Fruta e define uma laranja específica.
 * Uma laranja pode estar bichada e causar efeitos diferentes ao ser consumida.
 */
public class Laranja extends Fruta {

    /**
     * Constrói um objeto Laranja.
     *
     * @param bichada Indica se a laranja está bichada.
     */
    public Laranja(boolean bichada) {
        super(bichada, "la");
    }

    /**
     * Retorna uma lista com os efeitos causados pelo consumo da laranja.
     *
     * Se a laranja estiver bichada, o efeito de envenenamento será adicionado.
     * Caso contrário, o efeito de antídoto será adicionado, neutralizando os efeitos
     * de outras frutas bichadas.
     *
     * @return Uma lista com os efeitos causados pela laranja.
     */
    @Override
    public ArrayList<Efeitos> causarEfeito() {

        ArrayList<Efeitos> efeitos = new ArrayList<>();
        if (this.isBichada()) {
            efeitos.add(Efeitos.ENVENENAMENTO);
        } else {
            efeitos.add(Efeitos.ANTIDOTO);
        }
        return efeitos;
    }
}
