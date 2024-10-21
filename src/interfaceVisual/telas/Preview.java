package interfaceVisual.telas;

import interfaceVisual.componentes.PainelMapa;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

/** É uma classe que utiliza de um {@link JFrame} e um {@link JPanel} para mostrar ao usuário
 * um pré-visualização e um mapa de jogo selecionado.
 */
public class Preview {
    private JFrame frame;
    private JPanel panel;
    private PainelMapa painelMapa;

    /** Construtor recebe uma instância de {@link Mapa} e configura o {@link JFrame} da classe.
     * A instância de mapa é pintada sobre o {@link JPanel} a partir da classe {@link PainelMapa}.
     * @param mapa Um mapa do jogo.
     */
    public Preview(Mapa mapa) {
        frame = new JFrame("Preview");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/interfaceVisual/imagens/icones/previewIcon.png")));
        frame.setSize(mapa.getDimensao() * 50, mapa.getDimensao() * 50);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, mapa.getDimensao() * 50, mapa.getDimensao() * 50);

        painelMapa = new PainelMapa(mapa);

        panel.add(painelMapa);

        frame.add(panel);
        frame.setVisible(true);
    }

    public PainelMapa getPainelMapa() {
        return painelMapa;
    }
 }
