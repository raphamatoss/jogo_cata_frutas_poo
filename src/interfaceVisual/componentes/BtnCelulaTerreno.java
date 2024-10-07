package interfaceVisual.componentes;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Grama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnCelulaTerreno extends JButton {
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno) {
        super();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/verde.png"));

        setMargin(new Insets(0, 0, 0, 0));

        setBorder(BorderFactory.createEmptyBorder());

        // TODO: Quando formos implementar a movimentação do personagem, estou pensando em fazermos algumas visualizações de posições
        // que podemos chegar como no Xadrez.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createEmptyBorder());
            }
        });

        setIcon(icon);
    }
}
