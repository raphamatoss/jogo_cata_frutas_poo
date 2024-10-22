package interfaceVisual.paineis;

import javax.swing.*;

public abstract class PainelBase extends JPanel {

    private final int dimensao;

    public PainelBase(int dimensao) {
        this.dimensao = dimensao;

        setOpaque(false);
    }

    public PainelBase(int dimensao, int largura, int altura) {

        this.dimensao = dimensao;

        setOpaque(false);

        setBounds(0, 0, largura, altura);
    }

    // Método abstrato que deve ser implementado por classes filhas para configuração específica do grid
    protected abstract void inicializarPainel();

    public int getDimensao() {
        return dimensao;
    }
}