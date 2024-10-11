package modelo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta classe é responsável por acomodar métodos referentes à geração de valores aleatórios.
 */
public abstract class Randomizador {
    /**
     * Gera um número inteiro aleatório dentro de um intervalo específico.
     * <p>
     * Este método gera um número inteiro aleatório entre o valor inicial (`inicio`) e o valor final (`fim`),
     * inclusivos. Se o valor de `fim` for menor que o valor de `inicio`, a função ajusta o valor de `inicio`
     * para ser igual a `fim`, garantindo que o intervalo seja válido.
     *
     * @param inicio O valor inicial do intervalo (incluso).
     * @param fim O valor final do intervalo (inclusivo). Se `fim` for menor que `inicio`, `inicio` será ajustado para `fim`.
     * @return Um número inteiro aleatório entre `inicio` e `fim`, ambos inclusivos.
     *
     * @deprecated
     */
    public static int gerarInteiroAleatorio(int inicio, int fim) {
        if (fim < inicio) {
            inicio = fim;
        }

        return (int) (Math.random() * ((fim - inicio) + 1) + inicio);
    }

    /**
     * Este método recebe uma valor de referência, gera um valor aleatório e checa se o valor aleatório está antes ou depois do 
     * valor dado.
     *
     * @param probabilidadeParaTrue Probabilidade referência para decisão. [0 - 100]
     * @return {@code numeroSorteado<probabilidadeParaTrue}
     */
    public static boolean sortearTrue(int probabilidadeParaTrue) {
        // Verificar se a probabilidadeParaTrue está entre 0 e 100
        if (probabilidadeParaTrue < 0 || probabilidadeParaTrue > 100) {
            throw new IllegalArgumentException("A probabilidade deve estar entre 0 e 1.");
        }

        int numeroSorteado = gerarInteiroAleatorio(1, 99);

        return numeroSorteado < probabilidadeParaTrue;
    }

    /**
     * Essa função tem o propósito de selecionar dentro dos sprites um pacote padrão.
     * Ainda em desenvolvimento.
     */
    public static String sortearPacoteTextura() {
        final String CAMINHO_DIRETORIO_PACOTES = "src/interfaceVisual/imagens/blocos";

        List<String> pacotes = new ArrayList<>();

        File diretorio = new File(CAMINHO_DIRETORIO_PACOTES);

        if (diretorio.exists() && diretorio.isDirectory()) {
            for (File subDiretorio : diretorio.listFiles()) {
                if (subDiretorio.exists() && subDiretorio.isDirectory()) {
                    pacotes.add(subDiretorio.getName());
                }
            }
        } else {
            System.out.println("Diretório principal não encontrado: " + CAMINHO_DIRETORIO_PACOTES);
        }

        if (!pacotes.isEmpty()) {
            int indice = (int) (Math.random() * pacotes.size());

            String pacoteSorteado = pacotes.get(indice);

            return pacoteSorteado;
        } else {
            System.out.println("Nenhum pacote de textura foi encontrado.");

            return null;
        }
    }
}
