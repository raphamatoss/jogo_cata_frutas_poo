package frutas;

import entidades.Fruta;

public class Acerola extends Fruta {
    public Acerola(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "ac";
    }
}