package modelo.frutas;

import modelo.entidades.Fruta;

public class Coco extends Fruta {
    public Coco(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "co";
    }
}
