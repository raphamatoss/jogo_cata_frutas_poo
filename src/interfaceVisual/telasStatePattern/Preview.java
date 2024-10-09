package interfaceVisual.telasStatePattern;

import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Preview {
    JFrame frame;
    Jogo jogo;

    public Preview(Mapa mapa) {
        frame = new JFrame("Preview");
        //frame.setSize(512 + 16,312 + 39);
        frame.setPreferredSize(new Dimension(512, 312));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        jogo = new Jogo();
        jogo.setFrame(frame);
        jogo.setMapa(mapa);
        jogo.atualizarMapa(25, 512, 312);

        frame.pack();
        frame.setVisible(true);
    }
}
