package interfaceVisual.telasStatePattern;

// O que toda tela precisa ter?

import javax.swing.*;

public abstract class Tela {
    protected JPanel panel;
    protected Frame frame;

    public Tela() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 512, 312);
    }
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
