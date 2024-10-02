package modelo.frutas;

import modelo.entidades.Fruta;

public class Amora extends Fruta {
    public Amora(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "am ";
    }


}
