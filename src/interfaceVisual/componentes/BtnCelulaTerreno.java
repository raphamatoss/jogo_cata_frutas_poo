package interfaceVisual.componentes;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Grama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnCelulaTerreno extends JButton {
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno, String pacoteTextura) {
        super();

        ImageIcon icon = celulaTerreno.toImageIcon(pacoteTextura);

        setIcon(icon);

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
    }
}
