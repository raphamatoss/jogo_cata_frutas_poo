package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;

/**
 * Representa uma fruta do tipo amora.
 *
 * Esta classe estende a classe Fruta e define uma amora específica.
 */
public class Amora extends Fruta {
    public Amora(boolean bichada) {
        super(bichada, "am");
    }

}
