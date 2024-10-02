package modelo.frutas;

import modelo.entidades.Fruta;

public class Abacate extends Fruta {

    public Abacate(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "ab ";
    }
}
