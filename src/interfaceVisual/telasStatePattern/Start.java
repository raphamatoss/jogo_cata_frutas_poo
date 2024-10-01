package interfaceVisual.telasStatePattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends Tela {
    public Start(Frame frame){
        super(frame);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("./../imagens/backgroundTelaInicial.png"));
        JLabel background = new JLabel(icon);
        background.setSize(1024, 624);
        background.setBounds(0, 0, 1024, 624);

        ImageIcon botaoStartBackground = new ImageIcon(this.getClass().getResource("./../imagens/botoes/start.png"));
        JButton botaoStart = new JButton(botaoStartBackground);
        botaoStart.setBounds(400, 450, 200, 57);
        botaoStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
                frame.setState(frame.getMenu());
            }
        });

        ImageIcon botaoConfigBackground = new ImageIcon(this.getClass().getResource("./../imagens/botoes/config.png"));
        JButton botaoConfig = new JButton(botaoConfigBackground);
        botaoConfig.setBounds(920, 450, 57,57);
        botaoConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
                if (frame.getReprodutorDeSom().getIsAtivo()) {
                    frame.getReprodutorDeSom().pausarSom();
                    frame.getReprodutorDeSom().setIsAtivo(false);
                } else {
                    frame.getReprodutorDeSom().tocarSom();
                    frame.getReprodutorDeSom().setIsAtivo(true);
                }
            }
        });

        panel.add(botaoConfig);
        panel.add(botaoStart);
        panel.add(background);
    }
}
