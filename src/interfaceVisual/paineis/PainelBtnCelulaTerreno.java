package interfaceVisual.paineis;

import interfaceVisual.componentes.BtnCelulaTerreno;
import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;

public class PainelBtnCelulaTerreno extends PainelBase {

    private final Mapa mapa;

    public PainelBtnCelulaTerreno(Mapa mapa) {
        super(mapa.getDimensao());

        this.mapa = mapa;

        inicializarPainel();
    }

    public PainelBtnCelulaTerreno(Mapa mapa, int largura, int altura) {
        super(mapa.getDimensao(), largura, altura);

        this.mapa = mapa;

        inicializarPainel();
    }

    @Override
    protected void inicializarPainel() {
        CelulaTerreno[][] floresta = mapa.getFloresta();

        int larguraGrid = getDimensao() * 50;
        int alturaGrid = getDimensao() * 50;

        int inicioX = (this.getWidth() - larguraGrid) / 2;
        int inicioY = (this.getHeight() - alturaGrid) / 2;

        this.setLayout(null);

        for (int i = 0; i < getDimensao(); i++) {
            for (int j = 0; j < getDimensao(); j++) {
                int x = inicioX + i * 50;
                int y = inicioY + j * 50;

                BtnCelulaTerreno btnCelulaTerreno = new BtnCelulaTerreno(floresta[i][j], x, y);

                this.add(btnCelulaTerreno);
            }
        }

        this.revalidate();
        this.repaint();
    }
}

