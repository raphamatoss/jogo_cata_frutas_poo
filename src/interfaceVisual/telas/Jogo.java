package interfaceVisual.telas;

import interfaceVisual.paineis.PainelInterfaceJogador;
import interfaceVisual.paineis.PainelMapa;
import modelo.mapa.Mapa;

public class Jogo extends Tela {
    PainelInterfaceJogador painelInterfaceJogador;

    public Jogo(Frame frame, Mapa mapa) {
        super(frame);

        PainelMapa painelMapa = new PainelMapa(mapa, 624, 624);
        panel.add(painelMapa);

        painelInterfaceJogador = new PainelInterfaceJogador();
        panel.add(painelInterfaceJogador);
    }
}
