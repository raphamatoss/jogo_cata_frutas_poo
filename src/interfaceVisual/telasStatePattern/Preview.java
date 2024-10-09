package interfaceVisual.telasStatePattern;

import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Preview {
    JFrame frame;
    Jogo jogo;

    public Preview(Mapa mapa) {
        frame = new JFrame("Preview");
        frame.setSize(624 + 16,624 + 39); 
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        MapaPreview mapaPreview = new MapaPreview(frame, mapa);
        
        frame.add(mapaPreview.getPanel());
        frame.setVisible(true);
    }
}
