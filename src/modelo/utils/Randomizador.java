package modelo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Esta classe é responsável por acomodar métodos referentes à geração de valores aleatórios.
 */
public abstract class Randomizador {

    /**
     * Gera um número inteiro aleatório dentro de um intervalo específico.
     *
     * @param inicio O valor inicial do intervalo (incluso).
     * @param fim O valor final do intervalo (inclusivo). Se `fim` for menor que `inicio`, `inicio` será ajustado para `fim`.
     * @return Um número inteiro aleatório entre `inicio` e `fim`, ambos inclusivos.
     */
    public static int gerarInteiroAleatorio(int inicio, int fim) {
        if (fim < inicio) {
            inicio = fim;
        }
        return (int) (Math.random() * ((fim - inicio) + 1) + inicio);
    }

    /**
     * Este método recebe um valor de referência, gera um valor aleatório e checa se o valor aleatório está antes ou depois do
     * valor dado.
     *
     * @param probabilidadeParaTrue Probabilidade referência para decisão. [0 - 100]
     * @return {@code numeroSorteado < probabilidadeParaTrue}
     */
    public static boolean sortearTrue(int probabilidadeParaTrue) {
        if (probabilidadeParaTrue < 0 || probabilidadeParaTrue > 100) {
            throw new IllegalArgumentException("A probabilidade deve estar entre 0 e 100.");
        }

        int numeroSorteado = gerarInteiroAleatorio(1, 99);
        return numeroSorteado < probabilidadeParaTrue;
    }

    /**
     * Essa função tem o propósito de selecionar dentro dos sprites um pacote padrão.
     */
    public static String sortearPacoteTextura() {
        List<String> pacotes = new ArrayList<>();

        // TODO: Verificar como resolver a questão de nao conseguir sortear diretamente dos pacotes no diretório imagens/blocos.

        pacotes.add("verde");
        pacotes.add("verde_claro");
        pacotes.add("verde_escuro");


        if (!pacotes.isEmpty()) {
            int indice = (int) (Math.random() * pacotes.size());
            return pacotes.get(indice);
        } else {
            System.out.println("Nenhum pacote de textura foi encontrado.");
            return null;
        }
    }
}
