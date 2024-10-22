package interfaceVisual.paineis;

import modelo.utils.GeradorFlores;

import java.awt.*;

public class PainelFlores extends PainelBase {

    private GeradorFlores geradorFlores;

    public PainelFlores(int dimensao) {
        super(dimensao);

        inicializarPainel();
    }

    public PainelFlores(int dimensao, int largura, int altura) {
        super(dimensao, largura, altura);

        setBackground(Color.BLUE);

        inicializarPainel();
    }

    @Override
    protected void inicializarPainel() {
        this.geradorFlores = new GeradorFlores(getDimensao());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int larguraGrid = getDimensao() * 50;
        int alturaGrid = getDimensao() * 50;

        int inicioX = (this.getWidth() - larguraGrid) / 2;
        int inicioY = (this.getHeight() - alturaGrid) / 2;

        for (int i = 0; i < larguraGrid / 10; i++) {
            for (int j = 0; j < alturaGrid / 10; j++) {
                geradorFlores.posicionarFlor(this, i, j, inicioX, inicioY, g); // Passa o `Graphics` para desenhar
            }
        }
    }
}
