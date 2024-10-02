package modelo.arquivo;

import modelo.tipos.QuantidadeFrutas;
import modelo.mapa.MapaConfiguracao;
import java.util.Arrays;
import java.io.*;

public class GerenciadorMapaArquivo {

    // Para as funções a seguir eu usei a seguinte referência: https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/

    public static MapaConfiguracao importarArquivoTerreno(String caminhoArquivo) {
        BufferedReader br = null;
        MapaConfiguracao configMapa = new MapaConfiguracao();
        try {

            br = new BufferedReader(new FileReader(caminhoArquivo));

            String[] FrutasValidas = {"maracuja", "laranja", "abacate", "coco", "acerola", "amora", "goiaba" };

            while (br.ready()) {
                String linha = br.readLine();
                String[] partesLinhas = linha.split(" ");

                switch (partesLinhas[0].toLowerCase()) {
                    case "dimensao":
                        configMapa.setDimensao(Integer.parseInt(partesLinhas[1]));
                        break;
                    case "pedras":
                        configMapa.setQtdPedras(Integer.parseInt(partesLinhas[1]));
                        break;
                    case "bichadas":
                        configMapa.setProbabilidadeBichadas(Integer.parseInt(partesLinhas[1]));
                        break;
                    case "mochila":
                        configMapa.setTamanhoMochila(Integer.parseInt(partesLinhas[1]));
                        break;
                    default: if (Arrays.asList(FrutasValidas).contains(partesLinhas[0].toLowerCase())) {
                        configMapa.qntFrutasPorTipo.put(partesLinhas[0].toLowerCase(),new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2]))); 
                    }
                }
            }

            return configMapa;

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo.");
                    e.printStackTrace();
                }
            }
        }

        return null; // Retorna null caso haja erro na leitura do arquivo
    }

    public static void exportarArquivoTerreno(String caminhoArquivo, MapaConfiguracao configuracaoDoMapa) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(caminhoArquivo));

            bw.write(configuracaoDoMapa.toString());

            System.out.println("Arquivo exportado com sucesso para: " + caminhoArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + caminhoArquivo);
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo.");
                    e.printStackTrace();
                }
            }
        }
    }
}
