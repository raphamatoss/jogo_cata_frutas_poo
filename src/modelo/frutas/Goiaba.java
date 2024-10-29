package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;

/**
 * Representa uma fruta do tipo goiaba.
 *
 * Esta classe estende a classe Fruta e define uma goiaba específica.
 */
public class Goiaba extends Fruta {
    public Goiaba(boolean bichada) {
        super(bichada, "go");
    }

}
