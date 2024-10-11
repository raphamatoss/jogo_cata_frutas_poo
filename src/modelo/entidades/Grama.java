package modelo.entidades;

import modelo.utils.Imagem;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

public class Grama extends CelulaTerreno {

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
    public ImageIcon toImageIcon(String pacoteTextura) {
        String caminhoGrama = "src/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        ImageIcon iconGrama = new ImageIcon(caminhoGrama);

        if (this.frutaOcupante != null) {
            // Caso haja uma fruta naquela célula -> Combinar o sprite da fruta com o da grama.
            String nomeFruta = this.getFrutaOcupante().getClass().getSimpleName().toLowerCase();
            String caminhoFruta = "src/interfaceVisual/imagens/frutas/" + nomeFruta + ".png";

            ImageIcon iconFruta = new ImageIcon(caminhoFruta);

            BufferedImage imagemCombinada = Imagem.combinarImagens(iconGrama, iconFruta);

            return new ImageIcon(imagemCombinada);
        }

        return iconGrama;
    }
}
