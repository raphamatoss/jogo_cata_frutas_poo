package modelo.entidades;

// TODO: Provavelmente essa é uma das classes mais complexas!! Vamos precisar voltar aqui mais vezes...
// Definitivamente não está nem perto de finalizar

import modelo.tipos.Coordenada;
import modelo.utils.Efeitos;

/**
 * Classe que lida com o jogador.
 */
public class Jogador extends ElementoDinamico {

    private final String nome;
    private final Mochila<Fruta> mochila;
    private Integer ptsMovimento;
    private int forca = 0;
    private Efeitos efeito = Efeitos.NEUTRO;
    private CelulaTerreno celulaOcupada;

    public Jogador(String nome, Coordenada coordenada, int tamanhoMochila) {
        super(coordenada);
        this.nome = nome;
        this.mochila = new Mochila(tamanhoMochila);
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
    // ---------------------------------------------------

    public boolean coletarFruta(Fruta fruta){
        return this.mochila.armazenarFruta(fruta);
    }

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

    public void atualizar(){
        this.calcularForca();
        this.atualizarEfeito();
    }

    public void atualizarFimTurno(){

    }

    public void atualizarEfeito(){
        switch (this.efeito){
            case VELOCIDADE -> {

            }
            case FORCA -> {

            }
            case ENVENENAMENTO -> {

            }
        }
    }

    public void calcularForca(){
        this.forca = mochila.size();
    }

    // Verificar a classe Jogador Utils;

}
