package modelo.frutas;

import modelo.entidades.Fruta;

public class Goiaba extends Fruta {
    public Goiaba(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "go";
    }
}
