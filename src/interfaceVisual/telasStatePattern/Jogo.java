package interfaceVisual.telasStatePattern;

import modelo.entidades.CelulaTerreno;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Jogo extends Tela {
    Mapa mapa;
    JPanel panelMapa;
    JPanel panelInterfaceJogador;

    // TODO: Tentar criar uma maneira de fazer um componente para o botão de Célula: BtnCelulaMapa e ContainerMapa.
    // TODO: Tentar Componentizar os elementos da interface

    public Jogo(Frame frame) {
        super(frame);

        // Criação do painel específico para o mapa, com dimensões fixas de 624x624
        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        panelMapa.setBackground(Color.LIGHT_GRAY);  // Cor de fundo para visualizar a área reservada
        panelMapa.setBounds(0, 0, 624, 624);

        // Adiciona o painel de mapa ao painel principal
        panel.add(panelMapa);

        panelInterfaceJogador = new JPanel();
        panelInterfaceJogador.setLayout(null);
        panelInterfaceJogador.setBackground(Color.BLUE); // Temporário
        panelInterfaceJogador.setBounds(624, 0, 400, 624);
        panel.add(panelInterfaceJogador);
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void atualizarMapa() {
        if (mapa != null) {
            System.out.println("Mapa atualizado com sucesso!"); // Remover isso no Futuro

            // Isso daqui é temporário. Remover quando unirmos as telas de GerarMapa com o de Jogo.
            int dimensao = Math.min(mapa.getDimensao(), 12);

            CelulaTerreno[][] floresta = mapa.getFloresta();

            int tamanhoCelula = 50;

            // Dimensões totais do grid
            int larguraGrid = dimensao * tamanhoCelula;
            int alturaGrid = dimensao * tamanhoCelula;

            // Calcula a posição inicial para centralizar o grid no painel de 624x624
            int startX = (panelMapa.getWidth() - larguraGrid) / 2;
            int startY = (panelMapa.getHeight() - alturaGrid) / 2;

            // Remove os componentes antigos (caso esteja atualizando o mapa)
            panelMapa.removeAll();

            // Cria o grid de botões e os posiciona no painel centralizado
            JButton[][] buttons = new JButton[dimensao][dimensao];
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < dimensao; j++) {
                    // Cria o botão e define seu tamanho e posição
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBounds(startX + j * tamanhoCelula, startY + i * tamanhoCelula, tamanhoCelula, tamanhoCelula);

                    // Define o texto e estilo do botão
                    buttons[i][j].setText(floresta[i][j].toString());
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 10));

                    // Adiciona o botão ao painel de mapa
                    panelMapa.add(buttons[i][j]);
                }
            }

            // Atualiza o layout do painel de mapa e do painel principal
            panelMapa.revalidate();
            panelMapa.repaint();

        } else {
            System.out.println("Não temos o objeto mapa");
        }
    }
}
