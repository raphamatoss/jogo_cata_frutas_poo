package modelo.entidades;

import modelo.utils.Imagem;
import modelo.utils.Randomizador;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Pedra extends CelulaTerreno {

    public Pedra() {
        super();
    }


    /**
     * Gera o elemento para exibição no terminal.
     */
    /**
     * Responsável por gerar o modelo para exibição no terminal
     */
    @Override
    public String toString() {
        //Corrigir, fiz na pressa.
        if (this.getJogadorOcupante() != null) {
            return getJogadorOcupante().toString() + "/#";
        } else return "#";
    }
    /**
     * Gera a imagem para vizualização.
     */
    @Override
    public ImageIcon toImageIcon(String pacoteTextura) {
        String caminhoGrama = "/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        String caminhoPedra = "/interfaceVisual/imagens/pedras/pedra.png";

        ImageIcon iconGrama = new ImageIcon(this.getClass().getResource(caminhoGrama));
        ImageIcon iconPedra = new ImageIcon(this.getClass().getResource(caminhoPedra));

        BufferedImage imagemCombinada = Imagem.combinarImagens(iconGrama, iconPedra);

        return new ImageIcon(imagemCombinada);
    }
}
