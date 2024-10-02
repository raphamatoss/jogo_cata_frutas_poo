package frutas;

import entidades.Fruta;

public class Coco extends Fruta {
    public Coco(boolean bichada) {
        super(bichada);
    }

    @Override
    public void causarEfeito() {

    }

    @Override
    public String toString() {
        return "c";
    }
}