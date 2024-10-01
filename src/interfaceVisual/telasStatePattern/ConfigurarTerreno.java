package interfaceVisual.telasStatePattern;

import javax.swing.*;
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
                frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
            }
        });

        ImageIcon bgVoltar = new ImageIcon(this.getClass().getResource("./../imagens/botoes/voltar.png"));
        JButton botaoVoltar = new JButton(bgVoltar);
        botaoVoltar.setBounds(29, 32, 75,75);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getReprodutorDeSom().tocarSom("./soundtrack/pressionarBotao.mp3");
                frame.setState(frame.getMenu());
            }
        });

        ImageIcon bgAdicionar = new ImageIcon(this.getClass().getResource("./../imagens/botoes/mais.png"));
        ImageIcon bgRemover = new ImageIcon(this.getClass().getResource("./../imagens/botoes/menos.png"));
        ImageIcon bgDisplay = new ImageIcon(this.getClass().getResource("./../imagens/displayContador.png"));

        // dimensao
        JButton adicionarDimensao = new JButton(bgAdicionar);
        adicionarDimensao.setBounds(435, 175, 20,20);

        JButton removerDimensao = new JButton(bgRemover);
        removerDimensao.setBounds(375, 175, 20,20);

        JLabel numeroDimensao = new JLabel(bgDisplay);
        numeroDimensao.setBounds(400,170,30, 30);

        // frutas ouro no chao
        JButton adicionarFrutasOuroChao = new JButton(bgAdicionar);
        adicionarFrutasOuroChao.setBounds(435, 270, 20,20);

        JButton removerFrutasOuroChao = new JButton(bgRemover);
        removerFrutasOuroChao.setBounds(375, 270, 20,20);

        JLabel numeroFrutasOuroChao = new JLabel(bgDisplay);
        numeroFrutasOuroChao.setBounds(400,265,30, 30);

        // frutas ouro a surgir
        JButton adicionarFrutasOuroSurgir = new JButton(bgAdicionar);
        adicionarFrutasOuroSurgir.setBounds(435, 305, 20,20);

        JButton removerFrutasOuroSurgir = new JButton(bgRemover);
        removerFrutasOuroSurgir.setBounds(375, 305, 20,20);

        JLabel numeroFrutasOuroSurgir = new JLabel(bgDisplay);
        numeroFrutasOuroSurgir.setBounds(400,300,30, 30);

        // frutas diversas
        JButton adicionarFrutasDiversas = new JButton(bgAdicionar);
        adicionarFrutasDiversas.setBounds(435, 360, 20,20);

        JButton removerFrutasDiversas = new JButton(bgRemover);
        removerFrutasDiversas.setBounds(375, 360, 20,20);

        JLabel numeroFrutasDiversas = new JLabel(bgDisplay);
        numeroFrutasDiversas.setBounds(400,355,30, 30);

        // chance bichada
        JButton adicionarBichadas = new JButton(bgAdicionar);
        adicionarBichadas.setBounds(435, 415, 20,20);

        JButton removerBichadas = new JButton(bgRemover);
        removerBichadas.setBounds(375, 415, 20,20);

        JLabel numeroBichadas = new JLabel(bgDisplay);
        numeroBichadas.setBounds(400,410,30, 30);

        // pedras
        JButton adicionarPedras = new JButton(bgAdicionar);
        adicionarPedras.setBounds(435, 470, 20,20);

        JButton removerPedras = new JButton(bgRemover);
        removerPedras.setBounds(375, 470, 20,20);

        JLabel numeroPedras = new JLabel(bgDisplay);
        numeroPedras.setBounds(400,465,30, 30);

        // capacidade da mochila
        JButton adicionarCapacidade = new JButton(bgAdicionar);
        adicionarCapacidade.setBounds(435, 525, 20,20);

        JButton removerCapacidade = new JButton(bgRemover);
        removerCapacidade.setBounds(375, 525, 20,20);

        JLabel numeroCapacidade = new JLabel(bgDisplay);
        numeroCapacidade.setBounds(400,520,30, 30);

        // arvore coco
        JButton adicionarArvoreCoco = new JButton(bgAdicionar);
        adicionarArvoreCoco.setBounds(795, 229, 20,20);

        JButton removerArvoreCoco = new JButton(bgRemover);
        removerArvoreCoco.setBounds(735, 229, 20,20);

        JLabel numeroArvoresCoco = new JLabel(bgDisplay);
        numeroArvoresCoco.setBounds(760,224,30, 30);

        // arvore laranja
        JButton adicionarArvoreLaranja = new JButton(bgAdicionar);
        adicionarArvoreLaranja.setBounds(795, 271, 20,20);

        JButton removerArvoreLaranja = new JButton(bgRemover);
        removerArvoreLaranja.setBounds(735, 271, 20,20);

        JLabel numeroArvoresLaranja = new JLabel(bgDisplay);
        numeroArvoresLaranja.setBounds(760,266,30, 30);

        // arvore abacate
        JButton adicionarArvoreAbacate = new JButton(bgAdicionar);
        adicionarArvoreAbacate.setBounds(795, 314, 20,20);

        JButton removerArvoreAbacate = new JButton(bgRemover);
        removerArvoreAbacate.setBounds(735, 314, 20,20);

        JLabel numeroArvoresAbacate = new JLabel(bgDisplay);
        numeroArvoresAbacate.setBounds(760,309,30, 30);

        // "arvore" amora
        JButton adicionarArvoreAmora = new JButton(bgAdicionar);
        adicionarArvoreAmora.setBounds(795, 357, 20,20);

        JButton removerArvoreAmora = new JButton(bgRemover);
        removerArvoreAmora.setBounds(735, 357, 20,20);

        JLabel numeroArvoresAmora = new JLabel(bgDisplay);
        numeroArvoresAmora.setBounds(760,352,30, 30);

        // arvore acerola
        JButton adicionarArvoreAcerola = new JButton(bgAdicionar);
        adicionarArvoreAcerola.setBounds(795, 399, 20,20);

        JButton removerArvoreAcerola = new JButton(bgRemover);
        removerArvoreAcerola.setBounds(735, 399, 20,20);

        JLabel numeroArvoresAcerola = new JLabel(bgDisplay);
        numeroArvoresAcerola.setBounds(760,394,30, 30);

        // arvore goiaba
        JButton adicionarArvoreGoiaba = new JButton(bgAdicionar);
        adicionarArvoreGoiaba.setBounds(795, 441, 20,20);

        JButton removerArvoreGoiaba = new JButton(bgRemover);
        removerArvoreGoiaba.setBounds(735, 441, 20,20);

        JLabel numeroArvoresGoiaba = new JLabel(bgDisplay);
        numeroArvoresGoiaba.setBounds(760,436,30, 30);

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
