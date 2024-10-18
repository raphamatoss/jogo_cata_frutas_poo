package modelo.utils.perlin;

import interfaceVisual.componentes.BtnCelulaTerreno;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;
import modelo.mapa.MapaConfiguracao;
import modelo.utils.GeradorRuidoFlores;

import javax.swing.*;

public class TestePerlin {
	public static void main(String[] args) {
		/* SETUP */
		MapaConfiguracao mapaConfig = GerenciadorMapaArquivo.importarArquivoTerreno("input.txt");

		GeradorRuidoFlores geradorRuidoFlores = new GeradorRuidoFlores();

		assert mapaConfig != null;
		Mapa mapa = new Mapa(mapaConfig, 2);

		CelulaTerreno[][] floresta = mapa.getFloresta();

		int dimensao = mapa.getDimensao(); // Varia entre 5 a 12

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1024,1024);
		frame.setLayout(null);
		frame.setVisible(true);

		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				int posicaoX = j * 50;
				int posicaoY = i * 50;

				BtnCelulaTerreno btnCelulaTerreno = new BtnCelulaTerreno(floresta[i][j], "verde", posicaoX, posicaoY);

				geradorRuidoFlores.posicionarFloresBloco(btnCelulaTerreno, dimensao);

				frame.add(btnCelulaTerreno);

				frame.revalidate();
				frame.repaint();
			}
		}
	}
}