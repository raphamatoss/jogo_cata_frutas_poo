package modelo.entidades;

import modelo.frutas.Maracuja;

import java.util.ArrayList;
import java.util.Random;

/**
 * Representa uma mochila para armazenar frutas.
 *
 * A mochila possui um tamanho máximo e um contador para frutas do tipo maracujá.
 * Permite adicionar, remover e consultar informações sobre as frutas armazenadas.
 *
 * @param <T> O tipo de fruta que a mochila pode armazenar.
 */
public class Mochila<T> extends ArrayList<T> {

    private int tamanhoMochila;
    private int quantidadeFrutasOuro;

    public Mochila(int tamanhoMochila, int quantidadeFrutasOuro){
        this.tamanhoMochila = tamanhoMochila;
        this.quantidadeFrutasOuro = quantidadeFrutasOuro;
    }

    /**
     * Armazena uma fruta na mochila, se houver espaço disponível.
     *
     * Se a fruta for do tipo Maracuja, o contador de frutas de ouro é incrementado.
     *
     * @param fruta A fruta a ser armazenada.
     * @return `true` se a fruta foi armazenada com sucesso, `false` caso contrário.
     */
    public boolean armazenarFruta(T fruta) {
        if (this.size() < tamanhoMochila){
            this.add(fruta);
            if (fruta instanceof Maracuja) {
                quantidadeFrutasOuro++;
            }
            return true;
        }
        return false;
    }

    /**
     * Remove a primeira ocorrência da fruta especificada da mochila.
     *
     * @param fruta A fruta a ser removida.
     * @return A fruta removida, ou `null` se a fruta não for encontrada.
     */
    public Fruta retirarFrutaTipo(Fruta fruta) {
        int index = this.indexOf(fruta);
        if(index != -1){
            return (Fruta) this.remove(index);
        }
        return null;
    }

    /**
     * Remove uma quantidade aleatória de frutas da mochila, até o limite especificado.
     *
     * @param quantidadeFrutas A quantidade máxima de frutas a serem removidas.
     * @return Uma lista com as frutas removidas.
     */
    public ArrayList<Fruta> removeNFrutas(int quantidadeFrutas){
        ArrayList<Fruta> frutasRemovidas = new ArrayList<>();
        Random r = new Random();
        for(int n = 0; n < quantidadeFrutas && !this.isEmpty();n++){
            frutasRemovidas.add((Fruta) this.remove(r.nextInt(this.size())));
        }
        return frutasRemovidas;
    }

    public int getTamanhoMochila(){
        return tamanhoMochila;
    }

    public int getQuantidadeFrutasOuro(){
        return quantidadeFrutasOuro;
    }
}
