package modelo.utils.perlin;

public class TestePerlin {
	public static void main(String[] args) {
		int m = 3; // Varia entre 3 a 12

		// Cada bloco tem 50x50 pixels
		int tamanhoMapa = 3 * 50;

		PerlinNoise.setSeed(1);

		double limiarFlores = 0.5;

		for (int i = 0; i < tamanhoMapa; i++) {
			for (int j = 0; j < tamanhoMapa; j++) {
				if (PerlinNoise.perlin(i * 0.1, j * 0.1) < limiarFlores)
					System.out.print(". ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
	}
}
