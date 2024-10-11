package interfaceVisual.telasStatePattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Tela{
    public Menu (Frame frame) {
        super(frame);

        ImageIcon bgImage = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menu.png"));
        JLabel background = new JLabel(bgImage);
        background.setSize(1024, 624);
        background.setBounds(0, 0, 1024, 624);

        ImageIcon bgVoltar = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/voltar.png"));
        JButton botaoVoltar = new JButton(bgVoltar);
        botaoVoltar.setBounds(29, 32, 75,75);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarBotao();
                frame.setState(frame.getStart());
            }
        });

        ImageIcon bgSelecionar = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/botoes/selecionar.png"));

        // botao importar
        JButton botaoSelecionarImportar = new JButton(bgSelecionar);
        botaoSelecionarImportar.setBounds(169, 480, 310,49);
        botaoSelecionarImportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarBotao();
                frame.setState(frame.getImportarTerreno());
            }
        });

        // botao selecionar
        JButton botaoSelecionarConfigurar = new JButton(bgSelecionar);
        botaoSelecionarConfigurar.setBounds(569, 480, 310,49);
        botaoSelecionarConfigurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarBotao();
                frame.setState(frame.getConfigurarTerreno());
            }
        });

        panel.add(botaoSelecionarConfigurar);
        panel.add(botaoSelecionarImportar);
        panel.add(botaoVoltar);
        panel.add(background);
    }
}
