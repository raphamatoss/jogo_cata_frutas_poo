package modelo.entidades;

import modelo.tipos.Coordenada;
import modelo.utils.Efeitos;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um jogador no jogo.
 *
 * O jogador possui atributos como nome, mochila, força, efeitos e posição no mapa.
 * Ele pode coletar frutas, comer frutas, mover-se pelo mapa e ter seus atributos
 * modificados por efeitos.
 */
public class Jogador extends ElementoDinamico {

    private final String nome;
    private final Mochila<Fruta> mochila;
    private Integer ptsMovimento;
    private int forca = 0;
    private Efeitos efeito = Efeitos.NEUTRO;
    private CelulaTerreno celulaOcupada;
    private ArrayList<Efeitos> efeitos = new ArrayList<>(List.of(Efeitos.NEUTRO));

    public Jogador(String nome, Coordenada coordenada, int tamanhoMochila) {
        super(coordenada);
        this.nome = nome;
        this.mochila = new Mochila(tamanhoMochila, 0);
    }


    // getters & setters ------------------------------
    public CelulaTerreno getCelulaOcupada() {
        return celulaOcupada;
    }

    public void setCelulaOcupada(CelulaTerreno celulaOcupada) {
        this.celulaOcupada = celulaOcupada;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return this.forca;
    }
    public Integer getPtsMovimento() {
        return this.ptsMovimento;
    }
    public void setPtsMovimento(Integer pontos) {
        this.ptsMovimento = pontos;
    }
    public Mochila getMochila(){return this.mochila;}
    // ---------------------------------------------------

    /**
     * Coleta uma fruta e a adiciona à mochila do jogador.
     *
     * Se a mochila estiver cheia, a fruta não será coletada.
     *
     * @param fruta A fruta a ser coletada.
     * @return `true` se a fruta foi coletada com sucesso, `false` caso contrário.
     */
    public boolean coletarFruta(Fruta fruta){
        return this.mochila.armazenarFruta(fruta);
    }

    /**
     * Consome uma fruta da mochila do jogador.
     *
     * Ao consumir a fruta, os efeitos da fruta são aplicados ao jogador.
     *
     * @param fruta A fruta a ser consumida.
     * @return `true` se a fruta foi consumida com sucesso, `false` caso contrário.
     */
    public boolean comerFruta(Fruta fruta){
        Fruta frutaMochila = this.mochila.retirarFrutaTipo(fruta);
        if (frutaMochila != null){
            frutaMochila.causarEfeito();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO: Isso aqui é temporário...
        return "J" + this.nome;
    }

    /**
     * Calcula a força do jogador com base no número de frutas na mochila.
     *
     * A força do jogador é diretamente proporcional ao número de frutas na mochila.
     */
    public void calcularForca(){
        this.forca = mochila.size();
    }

    // Verificar a classe Jogador Utils;

}
