package modelo.entidades;

import modelo.utils.Imagem;
import modelo.utils.Randomizador;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Pedra extends CelulaTerreno {

    public Pedra() {
        super();
    }


    @Override
    public String toString() {
        return "#";
    }

    @Override
    public ImageIcon toImageIcon(String pacoteTextura) {
        String caminhoGrama = "src/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        String caminhoPedra = "src/interfaceVisual/imagens/pedras/pedra.png";

        ImageIcon iconGrama = new ImageIcon(caminhoGrama);
        ImageIcon iconPedra = new ImageIcon(caminhoPedra);

        BufferedImage imagemCombinada = Imagem.combinarImagens(iconGrama, iconPedra);

        return new ImageIcon(imagemCombinada);
    }
}
