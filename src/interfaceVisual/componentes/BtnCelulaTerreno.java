package interfaceVisual.componentes;

import modelo.entidades.CelulaTerreno;
import modelo.utils.Imagem;
import modelo.utils.Randomizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * A classe {@code BtnCelulaTerreno} estende {@link JButton} e é utilizada para criar botões que representam
 * células de terreno em um mapa. Ela parametriza o botão, definindo o ícone da célula e ajustando o comportamento
 * visual do botão quando o mouse interage com ele.
 */
public class BtnCelulaTerreno extends JButton {
    private final int posicaoX;
    private final int posicaoY;
    private final CelulaTerreno celulaTerreno;
    private ImageIcon celulaIcon; // Armazena o ícone da célula
    private final int tamanhoBloco = 50;


    /**
     * Construtor que cria um botão personalizado para representar uma célula de terreno no mapa.
     * O botão utiliza a imagem correspondente à célula, recebida como parâmetro.
     *
     * @param celulaTerreno  A instância de {@link CelulaTerreno} que contém as informações da célula que será
     *                       representada pelo botão.
     * @param pacoteTextura  O caminho para o pacote de texturas que contém a imagem a ser usada como ícone do botão.
     */
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno, String pacoteTextura, int posicaoX, int posicaoY) {
        super();

        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.celulaTerreno = celulaTerreno;
        this.celulaIcon = celulaTerreno.toImageIcon(pacoteTextura);

        this.setBounds(posicaoX, posicaoY, tamanhoBloco, tamanhoBloco);

        setIcon(celulaIcon);

        // Remove margens do botão para ajustar ao tamanho da célula
        setMargin(new Insets(0, 0, 0, 0));

        // Remove a borda padrão do botão
        setBorder(BorderFactory.createEmptyBorder());

        // Adiciona um listener para mudar a borda quando o mouse interage com o botão
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Define uma borda preta fina quando o mouse está sobre o botão
                setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove a borda quando o mouse sai do botão
                setBorder(BorderFactory.createEmptyBorder());
            }
        });
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public CelulaTerreno getCelulaTerreno() {
        return celulaTerreno;
    }

    public ImageIcon getCelulaIcon() {
        return celulaIcon;
    }

    public void setCelulaIcon(ImageIcon celulaIcon) {
        this.celulaIcon = celulaIcon;

        setIcon(celulaIcon);
    }

    public int getTamanhoBloco() {
        return tamanhoBloco;
    }

    /**
     * Método para adicionar o ícone de uma flor sobre a célula do terreno na posição especificada.
     * 
     * @param x A coordenada X onde a flor será posicionada.
     * @param y A coordenada Y onde a flor será posicionada.
     */
    public void posicionarFlor(int x, int y, String cor) {
        String caminhoFlor = "/interfaceVisual/imagens/flores/flor_" + cor + ".png";

        // Carrega a imagem da flor
        ImageIcon florIcon = new ImageIcon(this.getClass().getResource(caminhoFlor));

        // Utiliza o método combinarImagens da classe Imagem para combinar a célula e a flor na posição especificada
        BufferedImage imagemCombinada = Imagem.combinarImagens(celulaIcon, florIcon, x, y);

        // Define a nova imagem combinada como o ícone do botão
        setCelulaIcon(new ImageIcon(imagemCombinada));
    }
}