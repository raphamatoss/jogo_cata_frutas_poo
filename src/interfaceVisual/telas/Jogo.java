package interfaceVisual.telas;

import interfaceVisual.componentes.PainelInterfaceJogador;
import interfaceVisual.componentes.PainelMapa;
import modelo.mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class Jogo extends Tela {
    PainelMapa painelMapa;
    PainelInterfaceJogador painelInterfaceJogador;

    public Jogo(Frame frame, Mapa mapa) {
        super(frame);

        painelMapa = new PainelMapa(mapa, 624, 624);

        // botão configurações do jogo
        ImageIcon bgConfiguracoes = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/configuraçõesJogo.png"));
        JButton botaoConfiguracoesJogo = new JButton(bgConfiguracoes);
        botaoConfiguracoesJogo.setBounds(29, 32, 47, 49); // Define o tamanho e a posição do botão
        botaoConfiguracoesJogo.setBorderPainted(false);   // Remove a borda
        botaoConfiguracoesJogo.setFocusPainted(false);    // Remove o foco visual do botão
        botaoConfiguracoesJogo.setContentAreaFilled(false); // Remove a área de conteúdo padrão do botão
        botaoConfiguracoesJogo.addActionListener(e -> {
            frame.getReprodutorDeSom().tocarBotao();
            // Cria um novo diálogo para as configurações
            JDialog configuracoesDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(panel), "Configurações do Jogo", true);
            configuracoesDialog.setSize(300, 200); // Define o tamanho da janela de diálogo
            configuracoesDialog.setLayout(null); // Define o layout
            configuracoesDialog.getContentPane().setBackground(Color.decode("#d05000")); // Cor de fundo da janela

            // Botão "Voltar para Configurar Terreno"
            ImageIcon bgVoltar = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/voltarJogo.png"));
            JButton botaoVoltar = new JButton(bgVoltar);
            botaoVoltar.setBounds(53, 45, 70, 70);
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setToolTipText("Encerrar o jogo e voltar para o menu inicial");
            botaoVoltar.addActionListener(ev -> {
                frame.getReprodutorDeSom().tocarBotao();
                frame.setState(frame.getStart()); // Retorna à tela anterior
                configuracoesDialog.dispose(); // Fecha o diálogo
            });

            // botão "ativar/desativar som"
            ImageIcon bgSom;
            if (frame.getReprodutorDeSom().getIsAtivo()) {
                bgSom = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/somJogo.png"));
            } else {
                bgSom = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/soundOff.png"));
            }
            JButton botaoAtivarSom = new JButton(bgSom);
            botaoAtivarSom.setBounds(153, 45, 70, 70);
            botaoAtivarSom.setBorderPainted(false);
            botaoAtivarSom.setFocusPainted(false);
            botaoAtivarSom.setContentAreaFilled(false);
            botaoAtivarSom.setToolTipText("Ativar/Desativar o som do jogo");
            botaoAtivarSom.addActionListener(ev -> {
                frame.getReprodutorDeSom().tocarBotao();
                if (frame.getReprodutorDeSom().getIsAtivo()) {
                    frame.getReprodutorDeSom().pausarMusica();
                    frame.getReprodutorDeSom().setIsAtivo(false);
                } else {
                    frame.getReprodutorDeSom().reproduzirMusica();
                    frame.getReprodutorDeSom().setIsAtivo(true);
                }
                configuracoesDialog.dispose(); // Fecha o diálogo
            });
            // Adiciona os botões ao diálogo
            configuracoesDialog.add(botaoAtivarSom);
            configuracoesDialog.add(botaoVoltar);

            // Define a posição do diálogo no centro da tela
            configuracoesDialog.setLocationRelativeTo(null);

            // Torna o diálogo visível
            configuracoesDialog.setVisible(true);
        });

// Adiciona o botão ao painel principal
        panel.add(botaoConfiguracoesJogo);

        painelInterfaceJogador = new PainelInterfaceJogador();

        panel.add(painelMapa);
        panel.add(painelInterfaceJogador);
    }

    public void inicializarMapa(Mapa mapa) {
        if (mapa != null) {
            painelMapa.setMapa(mapa);

            // painelMapa.inicializarMapa();
        } else {
            System.out.println("[Java Swing] - Não há um mapa carregado.");
        }
    }
}
