package modelo.utils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GeradorFlores {

    private final int[][] matrizFloresRotularizada;
    private final Map<Integer, String> rotuloParaFlor;
    private final boolean DEBUG = false;

    public GeradorFlores(int dimensao) {
        int[][] matrizFlores = gerarMatrizFlores(dimensao);
        matrizFloresRotularizada = Grafos.rotularizarComponentesConexosVizinhanca4(matrizFlores);
        this.rotuloParaFlor = new HashMap<>();

        if (DEBUG) {
            for (int i = 0; i < matrizFloresRotularizada.length; i++) {
                for (int j = 0; j < matrizFloresRotularizada[0].length; j++) {
                    System.out.printf("%d ", matrizFloresRotularizada[i][j]);
                }
                System.out.println();
            }
        }
    }

    private int[][] gerarMatrizFlores(int dimensao) {
        int tamanhoMapa = dimensao * 50;
        PerlinNoise perlinNoise = new PerlinNoise();
        int[][] matrizFlores = new int[tamanhoMapa / 10][tamanhoMapa / 10];

        for (int i = 0; i < matrizFlores.length; i++) {
            for (int j = 0; j < matrizFlores[0].length; j++) {
                double ruido = perlinNoise.noise(i, j); // [-1, 1]
                double LIMIAR_FLORES = 0.4;
                matrizFlores[i][j] = (ruido <= -LIMIAR_FLORES || ruido >= LIMIAR_FLORES) ? 1 : 0;
                if (DEBUG) System.out.printf("%s ", matrizFlores[i][j] == 1 ? "F" : ".");
            }
            if (DEBUG) System.out.println();
        }

        return matrizFlores;
    }

    public void posicionarFlor(JPanel painel, int x, int y, int inicioX, int inicioY, Graphics g) {
        int rotulo = this.matrizFloresRotularizada[x][y];
        if (rotulo != 0) {
            if (!rotuloParaFlor.containsKey(rotulo)) {
                String florAleatoria = Randomizador.sortearFlor();
                rotuloParaFlor.put(rotulo, florAleatoria);
                if (DEBUG) System.out.printf("%d -> %s\n", rotulo, florAleatoria);
            }

            String corFlor = rotuloParaFlor.get(rotulo);
            String caminhoFlor = "/interfaceVisual/imagens/flores/flor_" + corFlor + ".png";
            Image imagemFlor = new ImageIcon(this.getClass().getResource(caminhoFlor)).getImage();

            if (imagemFlor != null) {
                // Agora desenha diretamente usando o `Graphics` fornecido
                g.drawImage(imagemFlor,inicioY + (y * 10), inicioX + (x * 10), 10, 10, painel);
            }
        }
    }
}
