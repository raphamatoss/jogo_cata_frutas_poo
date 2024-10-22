package interfaceVisual.telas;

import interfaceVisual.componentes.PainelInterfaceJogador;
import interfaceVisual.componentes.PainelMapa;
import interfaceVisual.paineis.PainelFlores;
import interfaceVisual.paineis.PainelGrama;
import modelo.mapa.Mapa;

public class Jogo extends Tela {
    PainelInterfaceJogador painelInterfaceJogador;

    public Jogo(Frame frame, Mapa mapa) {
        super(frame);

        PainelGrama painelGrama = new PainelGrama(mapa.getDimensao(), 624, 624);

        PainelFlores painelFlores = new PainelFlores(mapa.getDimensao(), 624, 624);

        painelInterfaceJogador = new PainelInterfaceJogador();

        panel.add(painelFlores);

        panel.add(painelGrama);

        panel.add(painelInterfaceJogador);
    }
}
