package modelo.entidades;

// TODO: Provavelmente essa é uma das classes mais complexas!! Vamos precisar voltar aqui mais vezes...
// Definitivamente não está nem perto de finalizar

import modelo.tipos.Coordenada;

/**
 * Classe que lida com o jogador.
 */
public class Jogador extends ElementoDinamico {

    private final String nome;
    private final Mochila mochila = new Mochila();
    private int ptsMovimento;

    public Jogador(String nome, Coordenada coordenada) {
        super(coordenada);
        this.nome = nome;

    }


    // getters & setters ------------------------------
    public String getNome() {
        return nome;
    }
    public int getForca() {
        return this.mochila.getFrutas().size();
    }
    public int getPtsMovimento() {
        return this.ptsMovimento;
    }
    public void setPtsMovimento(int pontos) {
        this.ptsMovimento = pontos;
    }
    // ---------------------------------------------------



    @Override
    public String toString() {
        // TODO: Isso aqui é temporário...
        return "J" + this.nome;
    }
}
