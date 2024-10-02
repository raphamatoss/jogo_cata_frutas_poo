package interfaceVisual.telasStatePattern;

import interfaceVisual.fontes.Press_Start_2P.PressStartFont;
import modelo.arquivo.VerificadorMapaArquivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurarTerreno extends Tela{

    public ConfigurarTerreno(Frame frame){
        super(frame);

        ImageIcon bgImage = new ImageIcon(this.getClass().getResource("./../imagens/menuConfigurarTerreno.png"));
        JLabel background = new JLabel(bgImage);
        background.setSize(1024, 624);
        background.setBounds(0, 0, 1024, 624);

        ImageIcon bgComecar = new ImageIcon(this.getClass().getResource("./../imagens/botoes/comecar.png"));
        JButton botaoComecar = new JButton(bgComecar);
        botaoComecar.setBounds(500, 510, 377,49);
        botaoComecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
            }
        });

        ImageIcon bgVoltar = new ImageIcon(this.getClass().getResource("./../imagens/botoes/voltar.png"));
        JButton botaoVoltar = new JButton(bgVoltar);
        botaoVoltar.setBounds(29, 32, 75,75);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
                frame.setState(frame.getMenu());
            }
        });

        ImageIcon bgAdicionar = new ImageIcon(this.getClass().getResource("./../imagens/botoes/mais.png"));
        ImageIcon bgRemover = new ImageIcon(this.getClass().getResource("./../imagens/botoes/menos.png"));
        ImageIcon bgDisplay = new ImageIcon(this.getClass().getResource("./../imagens/displayContador.png"));

        VerificadorMapaArquivo verificador = new VerificadorMapaArquivo();

        // dimensao
        JLabel numeroDimensao = new JLabel(bgDisplay);
        numeroDimensao.setBounds(400,170,30, 30);
        numeroDimensao.setText(Integer.toString(verificador.getDimensao()));
        numeroDimensao.setHorizontalTextPosition(JLabel.CENTER);
        numeroDimensao.setFont(new PressStartFont().getFont());
        numeroDimensao.setForeground(Color.white);

        JButton adicionarDimensao = new JButton(bgAdicionar);
        adicionarDimensao.setBounds(435, 175, 20,20);
        adicionarDimensao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getDimensao();
                if (verificador.setDimensao(atual + 1)) {
                    numeroDimensao.setText(Integer.toString(verificador.getDimensao()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerDimensao = new JButton(bgRemover);
        removerDimensao.setBounds(375, 175, 20,20);
        removerDimensao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getDimensao();
                if (verificador.setDimensao(atual - 1)) {
                    numeroDimensao.setText(Integer.toString(verificador.getDimensao()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // capacidade da mochila
        JLabel numeroCapacidade = new JLabel(bgDisplay);
        numeroCapacidade.setBounds(400,520,30, 30);
        numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
        numeroCapacidade.setHorizontalTextPosition(JLabel.CENTER);
        numeroCapacidade.setFont(new PressStartFont().getFont());
        numeroCapacidade.setForeground(Color.white);

        JButton adicionarCapacidade = new JButton(bgAdicionar);
        adicionarCapacidade.setBounds(435, 525, 20,20);
        adicionarCapacidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getTamanhoMochila();
                if (verificador.setTamanhoMochila(atual + 1)) {
                    numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerCapacidade = new JButton(bgRemover);
        removerCapacidade.setBounds(375, 525, 20,20);
        removerCapacidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getTamanhoMochila();
                if (verificador.setTamanhoMochila(atual - 1)) {
                    numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // frutas ouro no chao
        JLabel numeroFrutasOuroChao = new JLabel(bgDisplay);
        numeroFrutasOuroChao.setBounds(400,265,30, 30);
        numeroFrutasOuroChao.setText(Integer.toString(verificador.getFrutasOuroChao()));
        numeroFrutasOuroChao.setHorizontalTextPosition(JLabel.CENTER);
        numeroFrutasOuroChao.setFont(new PressStartFont().getFont());
        numeroFrutasOuroChao.setForeground(Color.white);

        JButton adicionarFrutasOuroChao = new JButton(bgAdicionar);
        adicionarFrutasOuroChao.setBounds(435, 270, 20,20);
        adicionarFrutasOuroChao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasOuroChao();
                if (verificador.setFrutasOuroChao(atual + 1)) {
                    numeroFrutasOuroChao.setText(Integer.toString(verificador.getFrutasOuroChao()));
                    if (verificador.verificarTamanhoMinimo(verificador.getFrutasOuroTotais(), verificador.getTamanhoMochila())) {
                        numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerFrutasOuroChao = new JButton(bgRemover);
        removerFrutasOuroChao.setBounds(375, 270, 20,20);
        removerFrutasOuroChao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasOuroChao();
                if (verificador.setFrutasOuroChao(atual - 1)) {
                    numeroFrutasOuroChao.setText(Integer.toString(verificador.getFrutasOuroChao()));
                    if (verificador.verificarTamanhoMinimo(verificador.getFrutasOuroTotais(), verificador.getTamanhoMochila())) {
                        numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // frutas ouro a surgir
        JLabel numeroFrutasOuroSurgir = new JLabel(bgDisplay);
        numeroFrutasOuroSurgir.setBounds(400,300,30, 30);
        numeroFrutasOuroSurgir.setText(Integer.toString(verificador.getFrutasOuroASurgir()));
        numeroFrutasOuroSurgir.setHorizontalTextPosition(JLabel.CENTER);
        numeroFrutasOuroSurgir.setFont(new PressStartFont().getFont());
        numeroFrutasOuroSurgir.setForeground(Color.white);

        JButton adicionarFrutasOuroSurgir = new JButton(bgAdicionar);
        adicionarFrutasOuroSurgir.setBounds(435, 305, 20,20);
        adicionarFrutasOuroSurgir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasOuroASurgir();
                if (verificador.setFrutasOuroASurgir(atual + 1)) {
                    numeroFrutasOuroSurgir.setText(Integer.toString(verificador.getFrutasOuroASurgir()));
                    if (verificador.verificarTamanhoMinimo(verificador.getFrutasOuroTotais(), verificador.getTamanhoMochila())) {
                        numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerFrutasOuroSurgir = new JButton(bgRemover);
        removerFrutasOuroSurgir.setBounds(375, 305, 20,20);
        removerFrutasOuroSurgir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasOuroASurgir();
                if (verificador.setFrutasOuroASurgir(atual - 1)) {
                    numeroFrutasOuroSurgir.setText(Integer.toString(verificador.getFrutasOuroASurgir()));
                    if (verificador.verificarTamanhoMinimo(verificador.getFrutasOuroTotais(), verificador.getTamanhoMochila())) {
                        numeroCapacidade.setText(Integer.toString(verificador.getTamanhoMochila()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // frutas diversas
        JLabel numeroFrutasDiversas = new JLabel(bgDisplay);
        numeroFrutasDiversas.setBounds(400,355,30, 30);
        numeroFrutasDiversas.setText(Integer.toString(verificador.getFrutasDiversas()));
        numeroFrutasDiversas.setHorizontalTextPosition(JLabel.CENTER);
        numeroFrutasDiversas.setFont(new PressStartFont().getFont());
        numeroFrutasDiversas.setForeground(Color.white);

        JButton adicionarFrutasDiversas = new JButton(bgAdicionar);
        adicionarFrutasDiversas.setBounds(435, 360, 20,20);
        adicionarFrutasDiversas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasDiversas();
                if (verificador.setFrutasDiversas(atual + 1)) {
                    numeroFrutasDiversas.setText(Integer.toString(verificador.getFrutasDiversas()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerFrutasDiversas = new JButton(bgRemover);
        removerFrutasDiversas.setBounds(375, 360, 20,20);
        removerFrutasDiversas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getFrutasDiversas();
                if (verificador.setFrutasDiversas(atual - 1)) {
                    numeroFrutasDiversas.setText(Integer.toString(verificador.getFrutasDiversas()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // chance bichada
        JLabel numeroBichadas = new JLabel(bgDisplay);
        numeroBichadas.setBounds(400,410,30, 30);
        String porcentagem = Integer.toString(verificador.getChanceBichada()) + "%";
        numeroBichadas.setText(porcentagem);
        numeroBichadas.setHorizontalTextPosition(JLabel.CENTER);
        numeroBichadas.setFont(new PressStartFont(7).getFont());
        numeroBichadas.setForeground(Color.white);

        JButton adicionarBichadas = new JButton(bgAdicionar);
        adicionarBichadas.setBounds(435, 415, 20,20);
        adicionarBichadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getChanceBichada();
                if (verificador.setChanceBichada(atual + 5)) {
                    String porcentagem = Integer.toString(verificador.getChanceBichada()) + "%";
                    numeroBichadas.setText(porcentagem);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerBichadas = new JButton(bgRemover);
        removerBichadas.setBounds(375, 415, 20,20);
        removerBichadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getChanceBichada();
                if (verificador.setChanceBichada(atual - 5)) {
                    String porcentagem = Integer.toString(verificador.getChanceBichada()) + "%";
                    numeroBichadas.setText(porcentagem);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        // pedras
        JLabel numeroPedras = new JLabel(bgDisplay);
        numeroPedras.setBounds(400,465,30, 30);
        numeroPedras.setText(Integer.toString(verificador.getPedras()));
        numeroPedras.setHorizontalTextPosition(JLabel.CENTER);
        numeroPedras.setFont(new PressStartFont().getFont());
        numeroPedras.setForeground(Color.white);

        JButton adicionarPedras = new JButton(bgAdicionar);
        adicionarPedras.setBounds(435, 470, 20,20);
        adicionarPedras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getPedras();
                if (verificador.setPedras(atual + 1)) {
                    numeroPedras.setText(Integer.toString(verificador.getPedras()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é maior do que o permitido!", "Valor Excedido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton removerPedras = new JButton(bgRemover);
        removerPedras.setBounds(375, 470, 20,20);
        removerPedras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int atual = verificador.getPedras();
                if (verificador.setPedras(atual - 1)) {
                    numeroPedras.setText(Integer.toString(verificador.getPedras()));
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor do que o permitido!", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // arvore coco
        JButton adicionarArvoreCoco = new JButton(bgAdicionar);
        adicionarArvoreCoco.setBounds(795, 229, 20,20);

        JButton removerArvoreCoco = new JButton(bgRemover);
        removerArvoreCoco.setBounds(735, 229, 20,20);

        JLabel numeroArvoresCoco = new JLabel(bgDisplay);
        numeroArvoresCoco.setBounds(760,224,30, 30);
        numeroArvoresCoco.setText(Integer.toString(verificador.getArvCoco()));
        numeroArvoresCoco.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresCoco.setFont(new PressStartFont().getFont());
        numeroArvoresCoco.setForeground(Color.white);

        // arvore laranja
        JButton adicionarArvoreLaranja = new JButton(bgAdicionar);
        adicionarArvoreLaranja.setBounds(795, 271, 20,20);

        JButton removerArvoreLaranja = new JButton(bgRemover);
        removerArvoreLaranja.setBounds(735, 271, 20,20);

        JLabel numeroArvoresLaranja = new JLabel(bgDisplay);
        numeroArvoresLaranja.setBounds(760,266,30, 30);
        numeroArvoresLaranja.setText(Integer.toString(verificador.getArvLaranja()));
        numeroArvoresLaranja.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresLaranja.setFont(new PressStartFont().getFont());
        numeroArvoresLaranja.setForeground(Color.white);

        // arvore abacate
        JButton adicionarArvoreAbacate = new JButton(bgAdicionar);
        adicionarArvoreAbacate.setBounds(795, 314, 20,20);

        JButton removerArvoreAbacate = new JButton(bgRemover);
        removerArvoreAbacate.setBounds(735, 314, 20,20);

        JLabel numeroArvoresAbacate = new JLabel(bgDisplay);
        numeroArvoresAbacate.setBounds(760,309,30, 30);
        numeroArvoresAbacate.setText(Integer.toString(verificador.getArvAbacate()));
        numeroArvoresAbacate.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresAbacate.setFont(new PressStartFont().getFont());
        numeroArvoresAbacate.setForeground(Color.white);

        // "arvore" amora
        JButton adicionarArvoreAmora = new JButton(bgAdicionar);
        adicionarArvoreAmora.setBounds(795, 357, 20,20);

        JButton removerArvoreAmora = new JButton(bgRemover);
        removerArvoreAmora.setBounds(735, 357, 20,20);

        JLabel numeroArvoresAmora = new JLabel(bgDisplay);
        numeroArvoresAmora.setBounds(760,352,30, 30);
        numeroArvoresAmora.setText(Integer.toString(verificador.getArvAmora()));
        numeroArvoresAmora.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresAmora.setFont(new PressStartFont().getFont());
        numeroArvoresAmora.setForeground(Color.white);

        // arvore acerola
        JButton adicionarArvoreAcerola = new JButton(bgAdicionar);
        adicionarArvoreAcerola.setBounds(795, 399, 20,20);

        JButton removerArvoreAcerola = new JButton(bgRemover);
        removerArvoreAcerola.setBounds(735, 399, 20,20);

        JLabel numeroArvoresAcerola = new JLabel(bgDisplay);
        numeroArvoresAcerola.setBounds(760,394,30, 30);
        numeroArvoresAcerola.setText(Integer.toString(verificador.getArvAcerola()));
        numeroArvoresAcerola.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresAcerola.setFont(new PressStartFont().getFont());
        numeroArvoresAcerola.setForeground(Color.white);

        // arvore goiaba
        JButton adicionarArvoreGoiaba = new JButton(bgAdicionar);
        adicionarArvoreGoiaba.setBounds(795, 441, 20,20);

        JButton removerArvoreGoiaba = new JButton(bgRemover);
        removerArvoreGoiaba.setBounds(735, 441, 20,20);

        JLabel numeroArvoresGoiaba = new JLabel(bgDisplay);
        numeroArvoresGoiaba.setBounds(760,436,30, 30);
        numeroArvoresGoiaba.setText(Integer.toString(verificador.getArvGoiaba()));
        numeroArvoresGoiaba.setHorizontalTextPosition(JLabel.CENTER);
        numeroArvoresGoiaba.setFont(new PressStartFont().getFont());
        numeroArvoresGoiaba.setForeground(Color.white);

        //comecar
        panel.add(botaoComecar);
        //voltar
        panel.add(botaoVoltar);
        //coco
        panel.add(adicionarArvoreCoco);
        panel.add(removerArvoreCoco);
        panel.add(numeroArvoresCoco);
        //amora
        panel.add(adicionarArvoreAmora);
        panel.add(removerArvoreAmora);
        panel.add(numeroArvoresAmora);
        //abacate
        panel.add(adicionarArvoreAbacate);
        panel.add(removerArvoreAbacate);
        panel.add(numeroArvoresAbacate);
        //laranja
        panel.add(adicionarArvoreLaranja);
        panel.add(removerArvoreLaranja);
        panel.add(numeroArvoresLaranja);
        //acerola
        panel.add(adicionarArvoreAcerola);
        panel.add(removerArvoreAcerola);
        panel.add(numeroArvoresAcerola);
        //goiaba
        panel.add(adicionarArvoreGoiaba);
        panel.add(removerArvoreGoiaba);
        panel.add(numeroArvoresGoiaba);
        //frutas ouro
        panel.add(adicionarFrutasOuroChao);
        panel.add(removerFrutasOuroChao);
        panel.add(numeroFrutasOuroChao);
        panel.add(adicionarFrutasOuroSurgir);
        panel.add(removerFrutasOuroSurgir);
        panel.add(numeroFrutasOuroSurgir);
        //frutas diversas
        panel.add(adicionarFrutasDiversas);
        panel.add(removerFrutasDiversas);
        panel.add(numeroFrutasDiversas);
        //frutas bichadas
        panel.add(adicionarBichadas);
        panel.add(removerBichadas);
        panel.add(numeroBichadas);
        //pedras
        panel.add(adicionarPedras);
        panel.add(removerPedras);
        panel.add(numeroPedras);
        //capacidade
        panel.add(adicionarCapacidade);
        panel.add(removerCapacidade);
        panel.add(numeroCapacidade);
        // dimensao
        panel.add(adicionarDimensao);
        panel.add(removerDimensao);
        panel.add(numeroDimensao);
        //background
        panel.add(background);
    }


}
