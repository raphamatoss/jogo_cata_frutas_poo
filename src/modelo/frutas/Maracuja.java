package modelo.frutas;

import modelo.entidades.Fruta;

public class Maracuja extends Fruta {
    public Maracuja(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "ma";
    }
}
