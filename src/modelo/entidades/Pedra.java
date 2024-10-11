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
        String caminhoGrama = "/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";
        String caminhoPedra = "/interfaceVisual/imagens/pedras/pedra.png";

        ImageIcon iconGrama = new ImageIcon(this.getClass().getResource(caminhoGrama));
        ImageIcon iconPedra = new ImageIcon(this.getClass().getResource(caminhoPedra));

        BufferedImage imagemCombinada = Imagem.combinarImagens(iconGrama, iconPedra);

        return new ImageIcon(imagemCombinada);
    }
}
