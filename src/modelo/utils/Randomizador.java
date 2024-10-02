package modelo.utils;

public abstract class Randomizador {
    /**
     * Gera um número inteiro aleatório dentro de um intervalo específico.
     * <p>
     * Esta função gera um número inteiro aleatório entre o valor inicial (`inicio`) e o valor final (`fim`),
     * inclusivos. Se o valor de `fim` for menor que o valor de `inicio`, a função ajusta o valor de `inicio`
     * para ser igual a `fim`, garantindo que o intervalo seja válido.
     *
     * @param inicio O valor inicial do intervalo (incluso).
     * @param fim O valor final do intervalo (inclusivo). Se `fim` for menor que `inicio`, `inicio` será ajustado para `fim`.
     * @return Um número inteiro aleatório entre `inicio` e `fim`, ambos inclusivos.
     *
     */
    public static int gerarInteiroAleatorio(int inicio, int fim) {
        if (fim < inicio) {
            inicio = fim;
        }

        return (int) (Math.random() * ((fim - inicio) + 1) + inicio);
    }

    // TODO: Será que podemos receber probabilidade do tipo double/float, caso sim precisamos ajustar toda a lógica de TerrenoConfiguracao e TerrenoArquivoManager
    public static boolean sortearTrue(int probabilidadeParaTrue) {
        // Verificar se a probabilidadeParaTrue está entre 0 e 100
        if (probabilidadeParaTrue < 0 || probabilidadeParaTrue > 100) {
            throw new IllegalArgumentException("A probabilidade deve estar entre 0 e 1.");
        }

        int numeroSorteado = gerarInteiroAleatorio(1, 99);

        return numeroSorteado < probabilidadeParaTrue;
    }
}