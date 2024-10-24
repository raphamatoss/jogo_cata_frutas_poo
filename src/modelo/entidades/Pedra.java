package modelo.entidades;

import modelo.utils.Imagem;

import javax.swing.*;
import java.awt.*;

public class Pedra extends CelulaTerreno {

    public Pedra() {
        super();
    }

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
    public Image toImage() {
        String caminhoPedra = "/interfaceVisual/imagens/pedras/pedra.png";

        ImageIcon iconPedra = new ImageIcon(this.getClass().getResource(caminhoPedra));

        if (this.getJogadorOcupante() != null) {
            String caminhoJogador;
            if (getJogadorOcupante().getNome().equals("J1"))
                caminhoJogador = "/interfaceVisual/imagens/jogadores/jogador1.png";
            else
                caminhoJogador = "/interfaceVisual/imagens/jogadores/jogador2.png";

            ImageIcon iconJogador = new ImageIcon(this.getClass().getResource(caminhoJogador));

            ImageIcon iconCombinado = new ImageIcon(Imagem.combinarImagens(iconPedra, iconJogador));

            return iconCombinado.getImage();
        }

        return iconPedra.getImage();
    }
}
