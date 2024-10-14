package interfaceVisual.telasStatePattern;

// O que toda tela precisa ter?

import javax.swing.*;

/** É uma classe abstrata que guarda um {@link Frame} e um {@link JPanel}. O {@link JPanel}
 * é configurado pela classe. Já o {@link Frame} é armazenado para facilitar na transição de telas.
 */
public abstract class Tela {
    protected JPanel panel;
    protected Frame frame;

    /** Construtor sem parâmetros que apenas configura o {@link JPanel}.
     */
    public Tela() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 512, 312);
    }

    /** Construtor que recebe e armazena um {@link Frame} bem como realizza a configuração do {@link JPanel}.
     * @param frame
     */
    public Tela(Frame frame) {
        this.frame = frame;
      
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1024, 624);
    }

    public JPanel getPanel() {
        return panel;
    }

    public Frame getFrame() {
        return frame;
    }
}
