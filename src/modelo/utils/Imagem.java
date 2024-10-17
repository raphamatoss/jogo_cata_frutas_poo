package modelo.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A classe Imagem contém utilitários para manipulação e combinação de imagens.
 */
public class Imagem {

    /**
     * Combina duas imagens, desenhando a imagem sobreposta em uma posição específica ou centralizada na imagem base.
     * 
     * <p>Se as coordenadas {@code x} e {@code y} forem fornecidas como -1, a imagem sobreposta será desenhada no centro.
     * Caso contrário, será desenhada nas coordenadas especificadas.</p>
     *
     * @param imagemBase       A imagem de fundo sobre a qual a segunda imagem será desenhada.
     * @param imagemSobreposta A imagem que será desenhada sobre a imagem base.
     * @param x                A coordenada X onde a imagem sobreposta será posicionada. Se for -1, centraliza horizontalmente.
     * @param y                A coordenada Y onde a imagem sobreposta será posicionada. Se for -1, centraliza verticalmente.
     * @return Um {@link BufferedImage} contendo a imagem base com a imagem sobreposta desenhada.
     * @throws IllegalArgumentException Se uma ou ambas as imagens forem inválidas (nulas).
     */
    public static BufferedImage combinarImagens(ImageIcon imagemBase, ImageIcon imagemSobreposta, int x, int y) {
        if (imagemBase.getImage() == null || imagemSobreposta.getImage() == null) {
            throw new IllegalArgumentException("Uma ou ambas as imagens são inválidas.");
        }

        // Cria um BufferedImage com o tamanho da imagem base
        int largura = imagemBase.getIconWidth();
        int altura = imagemBase.getIconHeight();
        BufferedImage imagemCombinada = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

        // Objeto Graphics2D para desenhar na imagem combinada
        Graphics2D g2d = imagemCombinada.createGraphics();

        // Desenha a imagem base
        g2d.drawImage(imagemBase.getImage(), 0, 0, largura, altura, null);

        // Obtém o tamanho da imagem sobreposta
        int larguraSobreposta = imagemSobreposta.getIconWidth();
        int alturaSobreposta = imagemSobreposta.getIconHeight();

        // Calcula a posição da imagem sobreposta
        int posX = (x == -1) ? (largura - larguraSobreposta) / 2 : x;
        int posY = (y == -1) ? (altura - alturaSobreposta) / 2 : y;

        // Desenha a imagem sobreposta na posição calculada
        g2d.drawImage(imagemSobreposta.getImage(), posX, posY, larguraSobreposta, alturaSobreposta, null);

        // Libera os recursos gráficos
        g2d.dispose();

        // Retorna a imagem combinada
        return imagemCombinada;
    }

    /**
     * Sobrecarga do método {@code combinarImagens} para centralizar a imagem sobreposta.
     *
     * @param imagemBase       A imagem de fundo.
     * @param imagemSobreposta A imagem que será desenhada no centro.
     * @return Um {@link BufferedImage} com a imagem sobreposta no centro.
     */
    public static BufferedImage combinarImagens(ImageIcon imagemBase, ImageIcon imagemSobreposta) {
        return combinarImagens(imagemBase, imagemSobreposta, -1, -1);
    }
}
