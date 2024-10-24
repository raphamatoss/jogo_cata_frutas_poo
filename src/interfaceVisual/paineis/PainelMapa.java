package interfaceVisual.paineis;

import java.awt.Color;

import javax.swing.JPanel;

import modelo.mapa.Mapa;

public class PainelMapa extends JPanel {
	
	public PainelMapa(Mapa mapa, int larguraPainel, int alturaPainel) {
		inicializarPaineis(mapa, larguraPainel, alturaPainel);
	}
	
	public PainelMapa(Mapa mapa) {
		int larguraPainel = mapa.getDimensao() * 50;
		int alturaPainel = mapa.getDimensao() * 50;
		
		inicializarPaineis(mapa, larguraPainel, alturaPainel);
	}
	
	private void inicializarPaineis(Mapa mapa, int larguraPainel, int alturaPainel) {
		setLayout(null);
		
		setBounds(0, 0, larguraPainel, alturaPainel);
		
		setBackground(Color.pink);
		
		PainelBtnCelulaTerreno painelBtnCelulaTerreno = new PainelBtnCelulaTerreno(mapa, larguraPainel, alturaPainel);
        this.add(painelBtnCelulaTerreno);

        PainelEntidades painelEntidadesMapa = new PainelEntidades(mapa, larguraPainel, alturaPainel);
        this.add(painelEntidadesMapa);

        PainelFlores painelFlores = new PainelFlores(mapa.getDimensao(), larguraPainel, alturaPainel);
        this.add(painelFlores);

        PainelGrama painelGrama = new PainelGrama(mapa.getDimensao(), larguraPainel, alturaPainel);
        this.add(painelGrama);
	}
}
