package interfaceVisual.paineis;

import modelo.utils.Randomizador;

import javax.swing.*;
import java.awt.*;

public class PainelGrama extends PainelBase {

    private ImageIcon imageIcon;

    public PainelGrama(int dimensao) {
        super(dimensao);

        inicializarPainel();
    }

    public PainelGrama(int dimensao, int largura, int altura) {
        super(dimensao, largura, altura);

        inicializarPainel();
    }

    @Override
    protected void inicializarPainel() {
        String pacoteTextura = Randomizador.sortearPacoteTextura();

        String caminhoGrama = "/interfaceVisual/imagens/blocos/" + pacoteTextura + "/grama.png";

        this.imageIcon = new ImageIcon(this.getClass().getResource(caminhoGrama));

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imageIcon != null) {
            int larguraGrid = getDimensao() * 50;
            int alturaGrid = getDimensao() * 50;

            int inicioX = (this.getWidth() - larguraGrid) / 2;
            int inicioY = (this.getHeight() - alturaGrid) / 2;

            Image imagemGrama = imageIcon.getImage();

            for (int i = 0; i < getDimensao(); i++) {
                for (int j = 0; j < getDimensao(); j++) {
                    int x = inicioX + i * 50;
                    int y = inicioY + j * 50;
                    g.drawImage(imagemGrama, x, y, 50, 50, this);
                }
            }
        }
    }
}