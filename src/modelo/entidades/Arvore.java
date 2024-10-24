package modelo.entidades;

import javax.swing.*;
import java.awt.*;

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


    public Arvore() {
        super();
        rodadasRestantesParaGerarFruta = 5; // TODO: Enquanto não tiver um jogadorOcupante isso daqui deve ser sempre 5
    }


    public int getRodadasRestantesParaGerarFruta() {
        return rodadasRestantesParaGerarFruta;
    }

    public void setRodadasRestantesParaGerarFruta(int rodadasRestantesParaGerarFruta) {
        this.rodadasRestantesParaGerarFruta = rodadasRestantesParaGerarFruta;
    }

    public void setFrutaDaArvore(Fruta fruta) {
        this.frutaDaArvore = fruta;
    }


    public void gerarFrutaArvore() {
        /* TODO: Será que transformamos essa função em abstract ou será que podemos usar algo chamado reflection
        A ideia que eu tive aqui foi a seguinte:
        - Essa função acessa o jogadorOcupante.mochila
        - Precisamos analisar a lógica da contagem das rodadas
        - Algumas verificações precisam ser feitas... Caso não haja espaço na mochila o que deve ocorrer?
        */
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
    public Image toImage() {
        String nomeFrutaArvore = this.frutaDaArvore.getClass().getSimpleName().toLowerCase();
        String caminhoArvore = "/interfaceVisual/imagens/arvores/arvore_" + nomeFrutaArvore + ".png";

        ImageIcon iconArvore = new ImageIcon(this.getClass().getResource(caminhoArvore));

        return iconArvore.getImage();
    }
}
