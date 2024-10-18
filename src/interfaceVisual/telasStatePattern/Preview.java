package interfaceVisual.telasStatePattern;

import interfaceVisual.componentes.PainelMapa;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

/** É uma classe que utiliza de um {@link JFrame} e um {@link JPanel} para mostrar ao usuário
 * um pré-visualização e um mapa de jogo selecionado.
 */
public class Preview {
    JFrame frame;
    JPanel panel;

    /** Construtor recebe uma instância de {@link Mapa} e configura o {@link JFrame} da classe.
     * A instância de mapa é pintada sobre o {@link JPanel} a partir da classe {@link PainelMapa}.
     * @param mapa Um mapa do jogo.
     */
    public Preview(Mapa mapa) {
        frame = new JFrame("Preview");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/interfaceVisual/imagens/previewIcon.png")));
        frame.setSize(624,624);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //MapaPreview mapaPreview = new MapaPreview(frame, mapa);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 624, 624);

        PainelMapa painelMapa = new PainelMapa(mapa);
        painelMapa.atualizarMapa();

        panel.add(painelMapa);

        frame.add(panel);
        frame.setVisible(true);
    }
}
