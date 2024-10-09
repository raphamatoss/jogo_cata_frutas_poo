package interfaceVisual.componentes;

import modelo.entidades.Arvore;
import modelo.entidades.CelulaTerreno;
import modelo.entidades.Grama;
import modelo.entidades.Pedra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnCelulaTerreno extends JButton {
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno) {
        super();

        ImageIcon icon;

        if (celulaTerreno instanceof Grama) {
            Grama grama = (Grama) celulaTerreno;
            icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/verde/verde.png"));
            /*
            if (grama.frutaOcupante.getNome() == "ac")
                icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/acerola.png"));
             */
        }
        else if (celulaTerreno instanceof Pedra)
            icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/verde1_com_pedra.png"));
        else
            icon = new ImageIcon(this.getClass().getResource("./../imagens/blocos/verde1_com_arvore_laranja.png"));

        setMargin(new Insets(0, 0, 0, 0));

        setBorder(BorderFactory.createEmptyBorder());

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
