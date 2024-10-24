package interfaceVisual.telas;

import interfaceVisual.paineis.PainelMapa;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

// TODO: Estou pensando um botão transparente com um dado para ir aleatorizando

/** É uma classe que utiliza de um {@link JFrame} e um {@link JPanel} para mostrar ao usuário
 * um pré-visualização e um mapa de jogo selecionado.
 */
public class Preview {
    private JFrame frame;
    private PainelMapa painelMapa;

    /** Construtor recebe uma instância de {@link Mapa} e configura o {@link JFrame} da classe.
     * A instância de mapa é pintada sobre o {@link JPanel} a partir da classe {@link PainelMapa}.
     * @param mapa Um mapa do jogo.
     */
    public Preview(Mapa mapa) {
        frame = new JFrame("Preview");

        int dimensao = mapa.getDimensao();

        // Verificar o sistema operacional
        String os = System.getProperty("os.name").toLowerCase();
        int margemX = 0, margemY = 0;

        // Se o sistema for Windows, adicionar margem
        if (os.contains("win")) {
            // TODO: Rapha veja qual o valor exato de margem que precisamos usar aqui.
            margemX = 10;
            margemY = 32; // Ajuste a margem conforme necessário
        }

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/interfaceVisual/imagens/icones/previewIcon.png")));
        frame.setSize((dimensao * 50) + margemX, (dimensao * 50) + margemY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        PainelMapa painelMapa = new PainelMapa(mapa);

        frame.add(painelMapa);

        frame.setVisible(true);
    }
 }
