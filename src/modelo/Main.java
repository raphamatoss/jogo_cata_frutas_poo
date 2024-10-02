package modelo;

import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.mapa.*;

public class Main {

	public static void main(String[] args) {

		MapaConfiguracao configuracaoDoMapa = GerenciadorMapaArquivo.importarArquivoTerreno("./input.txt");
		assert configuracaoDoMapa != null;

		Mapa mapa = new Mapa(configuracaoDoMapa, 2);
		mapa.visualizarTerreno();

		GerenciadorMapaArquivo.exportarArquivoTerreno("./output.txt", configuracaoDoMapa);
	}
}