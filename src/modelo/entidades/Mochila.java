package modelo.entidades;

import java.util.ArrayList;

// TODO: Provavelmente vamos precisar rever essa classe aqui
public class Mochila {
    private ArrayList<Fruta> frutas = new ArrayList<>();

    public ArrayList<Fruta> getFrutas() {
        return frutas;
    }

    public void armazenarFruta(Fruta fruta) {
        frutas.add(fruta);
    }

    public void desalocarFruta(Fruta fruta) {
        frutas.remove(fruta);
    }
}
