package interfaceVisual.componentes;

import interfaceVisual.paineis.PainelBtnCelulaTerreno;
import modelo.MovimentoJogador.GrafoJogador;
import modelo.entidades.CelulaTerreno;
import modelo.entidades.Jogador;
import modelo.mapa.Mapa;
import modelo.utils.Imagem;

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
    private final CelulaTerreno celulaTerreno;
    private final PainelBtnCelulaTerreno painelBtnCelulaTerreno;
    private final int posicaoX;
    private final int posicaoY;


    /**
     * Construtor que cria um botão personalizado para representar uma célula de terreno no mapa.
     * O botão utiliza a imagem correspondente à célula, recebida como parâmetro.
     *
     * @param celulaTerreno  A instância de {@link CelulaTerreno} que contém as informações da célula que será
     *                       representada pelo botão.
     *
     */
    public BtnCelulaTerreno(CelulaTerreno celulaTerreno, PainelBtnCelulaTerreno painelBtnCelulaTerreno, int posicaoX, int posicaoY) {
        super();

        this.celulaTerreno = celulaTerreno;
        this.painelBtnCelulaTerreno = painelBtnCelulaTerreno;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;

        this.setBounds(posicaoX, posicaoY, 50, 50);

        // Remove margens do botão para ajustar ao tamanho da célula
        setMargin(new Insets(0, 0, 0, 0));

        // Deixa o fundo transparente
        setOpaque(false);

        // Remove a cor do Fundo do Botão
        setContentAreaFilled(false);

        // Remove a borda padrão do botão
        setBorder(BorderFactory.createEmptyBorder());

        addMouseListener(new MouseAdapter() {

            // Evento de colocar os pesos de Pontos de Movimento nos botões
            @Override
            public void mouseEntered(MouseEvent e) {
                if (celulaTerreno.getJogadorOcupante() != null) {
                    Mapa mapa = painelBtnCelulaTerreno.getMapa();

                    Jogador jogadorOcupante = celulaTerreno.getJogadorOcupante();

                    GrafoJogador grafoJogador = new GrafoJogador(mapa);

                    grafoJogador.preencherMatriz(mapa, jogadorOcupante.getCoordenada());

                    painelBtnCelulaTerreno.mostrarPesos(grafoJogador.getMatrizCaminhos());
                }
            }

            // Evento de tirar os pesos de Pontos de Movimento nos botões
            @Override
            public void mouseExited(MouseEvent e) {
                if (celulaTerreno.getJogadorOcupante() != null) {
                    painelBtnCelulaTerreno.removerPesos();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void atualizarPeso(int peso) {
        if (peso > 0) {
            try {
                // Encontrando a imagem do Peso
                String caminhoPeso = "/interfaceVisual/imagens/blocos/pesos/peso" + peso + ".png";
                ImageIcon iconPeso = new ImageIcon(this.getClass().getResource(caminhoPeso));

                this.setIcon(iconPeso);

                // Estilos do texto para pontos de movimento do Jogador
                setForeground(Color.white);
                setHorizontalTextPosition(JButton.RIGHT);
                setVerticalTextPosition(JButton.TOP);
                setIconTextGap(-50);

                // Definindo o valor de pontos de movimento
                this.setText(Integer.toString(peso));

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public void removerPeso() {
        this.setIcon(null);
        this.setText("");
    }
}