package modelo.entidades;

import modelo.utils.FrutaTools;
import modelo.utils.Imagem;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * A classe árvore representa o elemento árvore do jogo, e contém os métodos para gerar frutas.
 */
public class Arvore extends CelulaTerreno {

    /**
     * Fruta que define qual será o tipo da árvore.
     */
    private Fruta frutaDaArvore;

    /**
     * Característica da árvore que dita em quanto tempo ela gerará uma fruta nova.
     */
    private int rodadasRestantesParaGerarFruta;
    public static int probabilidadeBichada;

    public Arvore() {
        super();
        rodadasRestantesParaGerarFruta = 5; // TODO: Enquanto não tiver um jogadorOcupante isso daqui deve ser sempre 5
    }


    // getters & setters -----------------------------------------------
    public int getRodadasRestantesParaGerarFruta() {
        return rodadasRestantesParaGerarFruta;
    }

    public void setRodadasRestantesParaGerarFruta(int rodadasRestantesParaGerarFruta) {
        this.rodadasRestantesParaGerarFruta = rodadasRestantesParaGerarFruta;
    }
    public Fruta getFrutaDaArvore() {
        return this.frutaDaArvore;
    }
    public void setFrutaDaArvore(Fruta fruta) {
        this.frutaDaArvore = fruta;
    }
    // ------------------------------------------------------------------


    private Fruta gerarFrutaArvore() {
        return FrutaTools.clonarFruta(this,this.probabilidadeBichada);
    }

    public void gerarMaracuja() {
        /*
        TODO: Minha ideia é a seguinte:
        - Terreno possui uma lista com todas as árvores do cenário
        - Uma função mestre acessa esse atributo do terreno e escolhe uma arvore a cada rodada par
        |-> Note que precisamos ter na nossa classe mestre um contador com o número de maracujá restantes a serem spawnados em arvores
        - Precisamos de testes para efetuar essa escolha.
        |-> Se maracujaRestantesArvore != 0 entao (se mRA % 2 == 0 and rodadaAtual != 0 entao gere a fruta)
        |-> Essa árvore é validada: possui uma vizinha 8 livre (consulte a seção 5 do manual)
        */
    }

    /**
     * Gera uma string para ser printada no terminal
     */
    @Override
    public String toString() {
        return this.frutaDaArvore.toString().toUpperCase();
    }

  
    /**
     * Gera a imagem correspondente à árvore.
     */
    @Override
    public ImageIcon toImageIcon(String pacoteTextura) {
        // Caminhos das imagens
        String caminhoGrama = "/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        String nomeFrutaArvore = this.frutaDaArvore.getClass().getSimpleName().toLowerCase();
        String caminhoArvore = "/interfaceVisual/imagens/arvores/arvore_" + nomeFrutaArvore + ".png";

        ImageIcon texturaGrama = new ImageIcon(this.getClass().getResource(caminhoGrama));
        ImageIcon arvore = new ImageIcon(this.getClass().getResource(caminhoArvore));

        BufferedImage imagemCombinada = Imagem.combinarImagens(texturaGrama, arvore);

        return new ImageIcon(imagemCombinada);
    }
}
