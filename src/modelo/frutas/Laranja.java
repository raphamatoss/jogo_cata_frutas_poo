package modelo.frutas;

import modelo.entidades.Fruta;

public class Laranja extends Fruta {
    public Laranja(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "la ";
    }
}
