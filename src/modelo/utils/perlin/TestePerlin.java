package modelo.utils.perlin;

public class TestePerlin {
	public static void main(String[] args) {
		int m = 3; // Varia entre 3 a 12

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

		for (int i = 0; i < tamanhoMapa; i++) {
			for (int j = 0; j < tamanhoMapa; j++) {
				if (ruidoMatriz[i][j] < limiarFlores)
					System.out.print(". ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
	}
}
