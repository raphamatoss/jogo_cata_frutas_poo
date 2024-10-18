package interfaceVisual.telasStatePattern;

import interfaceVisual.componentes.PainelInterfaceJogador;
import interfaceVisual.componentes.PainelMapa;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Jogo extends Tela {
    PainelMapa painelMapa;
    PainelInterfaceJogador painelInterfaceJogador;

    public Jogo(Frame frame) {
        super(frame);

        painelMapa = null;

        painelInterfaceJogador = new PainelInterfaceJogador();

        panel.add(painelMapa);
        panel.add(painelInterfaceJogador);
    }

    public void inicializarMapa(Mapa mapa) {
        if (mapa != null) {
            System.out.println("[Java Swing] - Há um mapa carregado.");
            painelMapa = new PainelMapa(mapa);

            painelMapa.atualizarMapa();
        } else {
            System.out.println("[Java Swing] - Não há um mapa carregado.");
        }
    }
}
