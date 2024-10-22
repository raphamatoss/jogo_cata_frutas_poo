package interfaceVisual.telas;

import interfaceVisual.componentes.PainelInterfaceJogador;
import interfaceVisual.paineis.PainelBtnCelulaTerreno;
import interfaceVisual.paineis.PainelEntidades;
import interfaceVisual.paineis.PainelFlores;
import interfaceVisual.paineis.PainelGrama;
import modelo.mapa.Mapa;

public class Jogo extends Tela {
    PainelInterfaceJogador painelInterfaceJogador;

    public Jogo(Frame frame, Mapa mapa) {
        super(frame);

        PainelBtnCelulaTerreno painelBtnCelulaTerreno = new PainelBtnCelulaTerreno(mapa, 624, 624);
        panel.add(painelBtnCelulaTerreno);

        PainelEntidades painelEntidadesMapa = new PainelEntidades(mapa, 624, 624);
        panel.add(painelEntidadesMapa);

        PainelFlores painelFlores = new PainelFlores(mapa.getDimensao(), 624, 624);
        panel.add(painelFlores);

        PainelGrama painelGrama = new PainelGrama(mapa.getDimensao(), 624, 624);
        panel.add(painelGrama);


        painelInterfaceJogador = new PainelInterfaceJogador();
        panel.add(painelInterfaceJogador);
    }
}
