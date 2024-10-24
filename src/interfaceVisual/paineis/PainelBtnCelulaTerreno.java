package interfaceVisual.paineis;

import interfaceVisual.componentes.BtnCelulaTerreno;
import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;

public class PainelBtnCelulaTerreno extends PainelBase {

    private final Mapa mapa;
    private BtnCelulaTerreno[][] matrizBtnCelulaTerreno;

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

        this.matrizBtnCelulaTerreno = new BtnCelulaTerreno[getDimensao()][getDimensao()];

        for (int i = 0; i < getDimensao(); i++) {
            for (int j = 0; j < getDimensao(); j++) {
                int x = inicioX + i * 50;
                int y = inicioY + j * 50;

                BtnCelulaTerreno btnCelulaTerreno = new BtnCelulaTerreno(floresta[i][j], this, x, y);

                matrizBtnCelulaTerreno[i][j] = btnCelulaTerreno;

                this.add(btnCelulaTerreno);
            }
        }

        this.revalidate();
        this.repaint();
    }

    /** Mostra no mapa o esquema de cores da distância de um jogador em um determinado
     * quadrado do mapa a todos os outros alcançaveis.
     * @param matrizCaminhos matriz com a quantidade de pontos de movimento necessários para o jogador se mover
     */
    public void mostrarPesos(Integer[][] matrizCaminhos) {
        for (int i = 0; i < matrizCaminhos.length; i++) {
            for (int j = 0; j < matrizCaminhos.length; j++) {
                this.matrizBtnCelulaTerreno[i][j].atualizarPeso(matrizCaminhos[i][j]);
            }
        }
    }

    public void removerPesos() {
        for (int i = 0; i < mapa.getDimensao(); i++) {
            for (int j = 0; j < mapa.getDimensao(); j++) {
                this.matrizBtnCelulaTerreno[i][j].removerPeso();
            }
        }
    }

    public Mapa getMapa() {
        return mapa;
    }
}

