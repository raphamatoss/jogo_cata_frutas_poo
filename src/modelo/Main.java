package modelo;

import interfaceVisual.telasStatePattern.Frame;
import interfaceVisual.telasStatePattern.Jogo;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.mapa.*;
import modelo.utils.Randomizador;

public class Main {

	public static void main(String[] args) {

		MapaConfiguracao configuracaoDoMapa = GerenciadorMapaArquivo.importarArquivoTerreno("./input.txt");
		assert configuracaoDoMapa != null;

		Mapa mapa = new Mapa(configuracaoDoMapa, 2);
		mapa.visualizarTerreno();

		Frame frame = new Frame();

		Jogo jogo = ((Jogo) frame.getJogo());

		jogo.inicializarMapa(mapa);
	}
}