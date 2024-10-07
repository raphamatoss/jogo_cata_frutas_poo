package interfaceVisual.componentes;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Grama;

import javax.swing.*;
import java.awt.*;

public class BtnCelulaTerreno extends JButton {
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno, int tamanho) {
        super();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/verde.png"));
        setSize(new Dimension(tamanho, tamanho));

        setIcon(icon);
    }
}
