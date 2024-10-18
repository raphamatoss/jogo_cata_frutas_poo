package modelo.utils;

import interfaceVisual.componentes.BtnCelulaTerreno;
import modelo.entidades.Grama;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GeradorRuidoFlores {
    private final double[][] ruidoMatriz;

    public GeradorRuidoFlores(int dimensao) {
        this.ruidoMatriz = gerarMatriz(dimensao, 50);
    }

    private double[][] gerarMatriz(int dimensao, int tamanhoBloco) {
        int tamanhoMapa = dimensao * tamanhoBloco;

        PerlinNoise perlinNoise = new PerlinNoise();

        double[][] ruidoMatriz = new double[tamanhoMapa][tamanhoMapa];

        for (int i = 0; i < tamanhoMapa; i++) {
            for (int j = 0; j < tamanhoMapa; j++) {
                double ruido = perlinNoise.noise(i, j); // [-1, 1]

                ruidoMatriz[i][j] = ruido;
            }
        }

        return ruidoMatriz;
    }

    public void posicionarFloresBloco(BtnCelulaTerreno btnCelulaTerreno) {
        if (btnCelulaTerreno.getCelulaTerreno() instanceof Grama grama) {
            int larguraFlor = 16, alturaFlor = 13;

            int posicaoX = btnCelulaTerreno.getPosicaoX();
            int posicaoY = btnCelulaTerreno.getPosicaoY();

            for (int florX = 0; florX < 50; florX += larguraFlor) {
                for (int florY = 0; florY < 50; florY += alturaFlor) {

                    double ruidoFlor = ruidoMatriz[posicaoX + florX][posicaoY + florY];

                    if ((ruidoFlor >= -1 && ruidoFlor <= -0.33) || (ruidoFlor > 0.33 && ruidoFlor <= 1))
                        if (florX + larguraFlor <= 50 && florY + alturaFlor <= 50)
                            btnCelulaTerreno.posicionarFlor(florX, florY, Randomizador.sortearFlor());
                }
            }

            if (grama.getFrutaOcupante() != null) {
                // Caso haja uma fruta naquela célula -> Combinar o sprite da fruta com o da grama.
                String nomeFruta = grama.getFrutaOcupante().getClass().getSimpleName().toLowerCase();

                String caminhoFruta = "/interfaceVisual/imagens/frutas/" + nomeFruta + ".png";

                ImageIcon iconFruta = new ImageIcon(this.getClass().getResource(caminhoFruta));

                ImageIcon iconGrama = btnCelulaTerreno.getCelulaIcon();

                BufferedImage imagemCombinada = Imagem.combinarImagens(iconGrama, iconFruta);

                btnCelulaTerreno.setCelulaIcon(new ImageIcon(imagemCombinada));
            }
        }
    }
}
