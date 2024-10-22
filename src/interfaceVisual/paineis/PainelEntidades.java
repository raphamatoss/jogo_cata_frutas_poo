package interfaceVisual.paineis;

import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;

import java.awt.*;

public class PainelEntidades extends PainelBase {

    private final Mapa mapa;

    public PainelEntidades(Mapa mapa) {
        super(mapa.getDimensao());

        this.mapa = mapa;

        inicializarPainel();
    }

    public PainelEntidades(Mapa mapa, int largura, int altura) {
        super(mapa.getDimensao(), largura, altura);

        this.mapa = mapa;

        inicializarPainel();
    }

    protected void inicializarPainel() {
        // Aqui você pode definir qualquer configuração inicial do painel, se necessário
        repaint(); // Chama repaint para garantir que o painel seja redesenhado
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        CelulaTerreno[][] floresta = mapa.getFloresta();

        int larguraGrid = mapa.getDimensao() * 50;
        int alturaGrid = mapa.getDimensao() * 50;

        int inicioX = (this.getWidth() - larguraGrid) / 2;
        int inicioY = (this.getHeight() - alturaGrid) / 2;

        for (int i = 0; i < mapa.getDimensao(); i++) {
            for (int j = 0; j < mapa.getDimensao(); j++) {
                int x = inicioX + i * 50;
                int y = inicioY + j * 50;

                Image imagemEntidade = floresta[i][j].toImage();

                g.drawImage(imagemEntidade, x, y, 40, 40, this);
            }
        }
    }

    public void atualizarPainel() {
        // TODO: Vini e Rapha completarem essa função quando o backend tiver pronto...
        repaint(); // Adicionei o repaint para garantir que o painel seja atualizado visualmente
    }

    public Mapa getMapa() {
        return mapa;
    }
}
