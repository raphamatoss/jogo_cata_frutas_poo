package modelo.utils.perlin;

import javax.swing.*;
import java.awt.*;

public class TestePerlin {
	public static void main(String[] args) {
		int m = 12; // Varia entre 5 a 12

		// Cada bloco tem 50x50 pixels
		int tamanhoMapa = m * 50;

		double limiarFlores = 0.5;

		PerlinNoise perlinNoise = new PerlinNoise();

		double[][] ruidoMatriz = new double[tamanhoMapa][tamanhoMapa];

		for (int i = 0; i < tamanhoMapa; i++) {
			for (int j = 0; j < tamanhoMapa; j++) {
				double ruido = perlinNoise.noise(i, j); // [-1, 1]

				double ruidoAjustado = (ruido + 1) / 2; // [0, 1]

				ruidoMatriz[i][j] = ruidoAjustado;
			}
		}

//		for (int i = 0; i < tamanhoMapa; i++) {
//			for (int j = 0; j < tamanhoMapa; j++) {
//				if (ruidoMatriz[i][j] < limiarFlores)
//					System.out.print(". ");
//				else
//					System.out.print("F ");
//			}
//			System.out.println();
//		}

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(tamanhoMapa,tamanhoMapa);
		frame.setLayout(null);
		frame.setVisible(true);

		for (int i = 0; i < tamanhoMapa; i++) {
			for (int j = 0; j < tamanhoMapa; j++) {
				JButton button = new JButton();

				ImageIcon icon = new ImageIcon("/interfaceVisual/imagens/blocos/verde/grama.png");

				button.setIcon(icon);

				int posicaoX = j * 50;
				int posicaoY = i * 50;

				button.setBounds(posicaoX,posicaoY,50,50);
				button.setMargin(new Insets(0, 0, 0, 0));


				frame.add(button);
			}
		}
	}
}
