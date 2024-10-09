package interfaceVisual.telasStatePattern;

import interfaceVisual.componentes.PainelInterfaceJogador;
import interfaceVisual.componentes.PainelMapa;
import modelo.mapa.Mapa;
import modelo.mapa.MapaConfiguracao;

import javax.swing.*;

public class MapaPreview {
    JFrame frame;
    JPanel panel;
    PainelMapa painelMapa;

    public MapaPreview(JFrame frame, Mapa mapa) {
        this.frame = frame;

        painelMapa = new PainelMapa();
        painelMapa.setMapa(mapa);
        painelMapa.atualizarMapa();
    }

    public JPanel getPanel() {
        return painelMapa;
    }

    public void inicializarMapa(Mapa mapa) {
        if (mapa != null) {
            System.out.println("[Java Swing] - Há um mapa carregado.");
            painelMapa.setMapa(mapa);

            painelMapa.atualizarMapa();
        } else {
            System.out.println("[Java Swing] - Não há um mapa carregado.");
        }
    }
}
