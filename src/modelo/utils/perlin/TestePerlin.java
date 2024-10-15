package modelo.utils.perlin;

public class TestePerlin {
	public static void main(String[] args) {
		int tamanho = 50;

		PerlinNoise.setSeed(1234);

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				System.out.printf("%.2f ", PerlinNoise.perlin(i * 0.1, j * 0.1));
			}
			System.out.println();
		}
	}
}
