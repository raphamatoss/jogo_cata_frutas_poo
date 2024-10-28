package modelo.entidades;

import java.util.ArrayList;
import java.util.Random;

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

    public ArrayList<Fruta> removeNFrutas(int quantidadeFrutas){
        ArrayList<Fruta> frutasRemovidas = new ArrayList<>();
        Random r = new Random();
        for(int n = 0; n < quantidadeFrutas && !this.isEmpty();n++){
            frutasRemovidas.add((Fruta) this.remove(r.nextInt(this.size())));
        }
        return frutasRemovidas;
    }
}
