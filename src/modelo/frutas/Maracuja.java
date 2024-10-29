package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;
/**
 * Representa uma fruta do tipo maracujá.
 *
 * Esta classe estende a classe Fruta e define um maracujá específico.
 */
public class Maracuja extends Fruta {
    /**
     * Constrói um objeto Maracuja.
     *
     * @param bichada Indica se o maracujá está bichado.
     */
    public Maracuja(boolean bichada) {
        super(bichada, "ma");
    }

}
