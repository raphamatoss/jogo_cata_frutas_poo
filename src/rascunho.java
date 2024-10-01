package terreno;

import frutas.Acerola;
import tipos.QuantidadeFrutas;
import java.io.*;
import java.util.ArrayList;

import static utils.Frutas.*;

public class GerenciadorDoArquivoDeMapa {

    // Para as funções a seguir eu usei a seguinte referência: https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/

    public static ConfiguracaoDoMapa importarArquivoTerreno(String caminhoArquivo) {
        BufferedReader br = null;
        ConfiguracaoDoMapa configMapa = new ConfiguracaoDoMapa();
        try {
            br = new BufferedReader(new FileReader(caminhoArquivo));

            String[] FrutasValidas = new Array<String>() = {
                "maracuja",
                "laranja",
                "abacate",
                "coco",
                "acerola",
                "amora",
                "goiaba"
            }

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
                    case "maracuja":
                        configMapa.addInKey("maracuja", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "laranja":
                        configMapa.addInKey("laranja", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "abacate":
                        configMapa.addInKey("abacate", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "coco":
                        configMapa.addInKey("coco", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "acerola":
                        configMapa.addInKey("acerola", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "amora":
                        configMapa.addInKey("amora", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "goiaba":
                        configMapa.addInKey("goiaba", new QuantidadeFrutas(Integer.parseInt(partesLinhas[1]), Integer.parseInt(partesLinhas[2])));
                        break;
                    case "bichadas":
                        configMapa.setProbabilidadeBichadas(Integer.parseInt(partesLinhas[1]));
                        break;
                    case "mochila":
                        configMapa.setTamanhoMochila(Integer.parseInt(partesLinhas[1]));
                        break;
                    default: 
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

    public static void exportarArquivoTerreno(String caminhoArquivo, ConfiguracaoDoMapa configuracaoDoMapa) {
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
