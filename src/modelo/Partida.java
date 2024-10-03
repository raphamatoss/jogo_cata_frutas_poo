package modelo;

import interfaceVisual.telasStatePattern.Frame;
import interfaceVisual.telasStatePattern.Jogo;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.mapa.*;

public class Partida {

	public static void main(String[] args) {

		MapaConfiguracao configuracaoDoMapa = GerenciadorMapaArquivo.importarArquivoTerreno("./input.txt");
		assert configuracaoDoMapa != null;

		Mapa mapa = new Mapa(configuracaoDoMapa, 2);
		mapa.visualizarTerreno();

		GerenciadorMapaArquivo.exportarArquivoTerreno("./output.txt", configuracaoDoMapa);

		Frame frame = new Frame();

		Jogo jogo = ((Jogo) frame.getJogo());

		jogo.setMapa(mapa);

		jogo.atualizarMapa();
	}
}