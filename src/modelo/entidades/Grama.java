package modelo.entidades;

import modelo.utils.Imagem;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Essa classe corresponde ao elemento básico de terreno e é o único qeu pode conter uma fruta frutaOcupante.
 */
public class Grama extends CelulaTerreno {

    /**
     * Fruta ocupante da posição da grama.
     */
    public Fruta frutaOcupante;

    public Grama() {
        super();
        this.frutaOcupante = null;
    }

    public Fruta getFrutaOcupante() {
        return frutaOcupante;
    }

    public void setFrutaOcupante(Fruta frutaOcupante) {
        this.frutaOcupante = frutaOcupante;
    }

    /**
     * Responsável por gerar o modelo para exibição no terminal
     */
    @Override
    public String toString() {
        //Corrigir, fiz na pressa.
        if (this.getJogadorOcupante() != null && frutaOcupante == null) {
            return getJogadorOcupante().toString();
        } else if (this.getJogadorOcupante() != null && frutaOcupante != null) {
            return getJogadorOcupante().toString() + "/" + frutaOcupante.toString();
        } else if (frutaOcupante != null) {
            return frutaOcupante.toString();
        } else return ".";
    }

    @Override
    public Image toImage() {
        BufferedImage imagemVazia = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        ImageIcon iconCombinado = new ImageIcon(imagemVazia);

        if (this.frutaOcupante != null) {
            // Caso haja uma fruta naquela célula -> Combinar o sprite da fruta com o da grama.
            String nomeFruta = this.getFrutaOcupante().getClass().getSimpleName().toLowerCase();
            String caminhoFruta = "/interfaceVisual/imagens/frutas/" + nomeFruta + ".png";

            ImageIcon iconFruta = new ImageIcon(this.getClass().getResource(caminhoFruta));

            iconCombinado = new ImageIcon(Imagem.combinarImagens(iconCombinado, iconFruta));
        }

        if (this.getJogadorOcupante() != null) {
            String caminhoJogador;
            if (getJogadorOcupante().getNome().equals("J1"))
                caminhoJogador = "/interfaceVisual/imagens/jogadores/jogador1.png";
            else
                caminhoJogador = "/interfaceVisual/imagens/jogadores/jogador2.png";

            ImageIcon iconJogador = new ImageIcon(this.getClass().getResource(caminhoJogador));

            iconCombinado = new ImageIcon(Imagem.combinarImagens(iconCombinado, iconJogador));
        }

        return iconCombinado.getImage();
    }
}
