package modelo.entidades;

import modelo.utils.Randomizador;

import javax.swing.*;

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
        boolean cogumelo = Randomizador.sortearTrue(75);

        String caminho = "./interfaceVisual/imagens/blocos/" + pacoteTextura + (cogumelo ? "/pedra.png" : "/pedra_com_cogumelos.png");

        return new ImageIcon(caminho);
    }
}
