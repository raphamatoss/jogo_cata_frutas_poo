package interfaceVisual.componentes;

import modelo.entidades.CelulaTerreno;

import javax.swing.*;
import java.awt.*;

public class BtnCelulaTerreno extends JButton {
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno, int tamanhoPreferencia) {
        // Temporário
        super(celulaTerreno.toString());
        setFont(new Font("Arial", Font.BOLD, 10));
        setSize(new Dimension(tamanhoPreferencia, tamanhoPreferencia));
    }
}
