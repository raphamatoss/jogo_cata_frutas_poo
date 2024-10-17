package modelo.utils.perlin;

import interfaceVisual.componentes.BtnCelulaTerreno;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;
import modelo.mapa.MapaConfiguracao;

import javax.swing.*;

public class TestePerlin {
	public static void main(String[] args) {
		MapaConfiguracao mapaConfig = GerenciadorMapaArquivo.importarArquivoTerreno("input.txt");

        assert mapaConfig != null;
        Mapa mapa = new Mapa(mapaConfig, 2);

		CelulaTerreno[][] floresta = mapa.getFloresta();

		int m = mapa.getDimensao(); // Varia entre 5 a 12

		// Cada bloco tem 50x50 pixels
		int tamanhoMapa = m * 50 + 50;

		double limiarFlores = 0.5;

		PerlinNoise perlinNoise = new PerlinNoise();

		double[][] ruidoMatriz = new double[tamanhoMapa][tamanhoMapa];

		for (int i = 0; i < tamanhoMapa; i++) {
			for (int j = 0; j < tamanhoMapa; j++) {
				double ruido = perlinNoise.noise(i, j); // [-1, 1]

				double ruidoAjustado = (ruido + 1) / 2; // [0, 1]

				ruidoMatriz[i][j] = ruidoAjustado;
				
				if (ruidoAjustado < limiarFlores)
					System.out.print(". ");
				else
					System.out.print("F ");
			}
			
			System.out.println();
		}

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(tamanhoMapa,tamanhoMapa);
		frame.setLayout(null);
		frame.setVisible(true);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				BtnCelulaTerreno btnCelulaTerreno = new BtnCelulaTerreno(floresta[i][j], "verde");

				int posicaoX = j * 50;
				int posicaoY = i * 50;

				btnCelulaTerreno.setBounds(posicaoX, posicaoY, 50, 50);

				frame.add(btnCelulaTerreno);

				frame.revalidate();
				frame.repaint();
			}
		}
	}
}
