package modelo.entidades;

import modelo.utils.Imagem;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

/**
 * Essa classe corresponde ao elemento básico de terreno e é o único qeu pode conter uma fruta frutaOcupante.
 */
public class Grama extends CelulaTerreno {

    /**
     * Fruta ocupante da posição da grama.
     */
    private Fruta frutaOcupante;

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

    /**
     * Gera a imagem da grama com base em uma seleção de pacotes de sprites.
     */
    @Override
    public ImageIcon toImageIcon(String pacoteTextura) {
        String caminhoGrama = "/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        ImageIcon iconGrama = new ImageIcon(this.getClass().getResource(caminhoGrama));

        return iconGrama;
    }
}
