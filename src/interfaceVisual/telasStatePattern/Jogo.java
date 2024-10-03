package interfaceVisual.telasStatePattern;

import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Jogo extends Tela {
    Mapa mapa;

    public Jogo(Frame frame) {
        super(frame);
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void atualizarMapa() {
        if (mapa != null) {
            // TODO: Remover esse sysout no futuro
            System.out.println("ok! temos o objeto mapa");

            // TODO: Estou limitando para 6x6 o máximo, porém essa limitação nao deve ser feita aqui.
            // TODO: Essa limitação também não foi discutida pelas partes.
            int dimensao = Math.min(mapa.getDimensao(), 10);

            CelulaTerreno[][] floresta = mapa.getFloresta();

            // Tamanho fixo de 50x50 para a célula. TODO: Isso é temporário, precisamos discutir sobre
            int tamanhoCelula = 50;

            // Dimensões totais do grid
            int larguraGrid = dimensao * tamanhoCelula;
            int alturaGrid = dimensao * tamanhoCelula;

            // Calcula a posição inicial para centralizar o grid no painel
            int startX = (1024 - larguraGrid) / 2;
            int startY = (648 - alturaGrid) / 2;

            // Cria o grid de botões e os posiciona no painel centralizado
            JButton[][] buttons = new JButton[dimensao][dimensao];
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < dimensao; j++) {
                    // Cria o botão e define seu tamanho e posição
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBounds(startX + j * tamanhoCelula, startY + i * tamanhoCelula, tamanhoCelula, tamanhoCelula);

                    buttons[i][j].setText(floresta[i][j].toString());
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 10));

                    // Adiciona o botão ao painel
                    panel.add(buttons[i][j]);
                }
            }

            // Atualiza o layout do painel
            panel.revalidate();
            panel.repaint();

        } else {
            // TODO: Remover esse sysout no futuro. Pode ser uma tela de loading enquanto monta o mapa
            System.out.println("nao temos o objeto mapa");
        }
    }
}
