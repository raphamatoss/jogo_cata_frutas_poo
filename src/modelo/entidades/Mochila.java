package modelo.entidades;

import java.util.ArrayList;

// TODO: Provavelmente vamos precisar rever essa classe aqui
public class Mochila<T> extends ArrayList<T> {

    private int tamanhoMochila;

    public Mochila(int tamanhoMochila){
        this.tamanhoMochila = tamanhoMochila;
    }

    public boolean armazenarFruta(T fruta) {
        if (this.size() < tamanhoMochila){
            this.add(fruta);
            return true;
        }
        return false;
    }

    public Fruta retirarFrutaTipo(Fruta fruta) {
        int index = this.indexOf(fruta);
        if(index != -1){
            return (Fruta) this.remove(index);
        }
        return null;
    }
}
