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
        super.paintComponent(g); // Chama o método original para garantir a correta renderização do painel

        int[][] matrizFlores = geradorFlores.getMatrizFloresRotularizada();
        int tamanhoGrid = getDimensao() * 50; // Ajuste do tamanho da área

        for (int i = 0; i < tamanhoGrid / 10; i++) {
            for (int j = 0; j < tamanhoGrid / 10; j++) {
                geradorFlores.posicionarFlor(this, i, j, g); // Passa o `Graphics` para desenhar
            }
        }
    }
}
