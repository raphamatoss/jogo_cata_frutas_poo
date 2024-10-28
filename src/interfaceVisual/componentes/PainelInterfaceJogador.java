package interfaceVisual.componentes;

import modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe {@code PainelInterfaceJogador} estende {@link JPanel} e é utilizada para representar a interface do jogador,
 * onde futuramente será exibido o menu do jogador.
 * Atualmente, o painel é configurado de forma temporária com um fundo azul e um layout absoluto.
 */
public class PainelInterfaceJogador extends JPanel {
    private Partida partida;
    private boolean controle;
    /**
     * Construtor padrão que inicializa o painel com configurações temporárias.
     * O painel tem fundo azul e está posicionado à direita do mapa com um layout absoluto.
     * No futuro, essa área será usada para o menu do jogador.
     */
    public PainelInterfaceJogador(Partida partida) {
        this.partida = partida;

        // Define o layout absoluto (null layout)
        setLayout(null);

        //define a cor do painel
        setBackground(Color.decode("#ff9429")); // Temporário

        // Define as dimensões e posição do painel
        setBounds(624, 0, 400, 624);

        // label players
        ImageIcon players = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menuJogador/players.png"));
        JLabel player = new JLabel(players);
        player.setSize(161, 149); // Ajusta para o tamanho desejado
        player.setBounds(17, 28, 161, 149); // Posição e tamanho do JLabel
        this.add(player);
        ImageIcon spritePlayer1 = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menuJogador/spriteJogador1.png"));
        JLabel player1 = new JLabel(spritePlayer1);
        player1.setSize(130, 115);
        player1.setBounds(32, 45, 130, 115);
        this.add(player);
        this.add(player1);
        this.setComponentZOrder(player1, 0); // Coloca o player1 no topo
        this.setComponentZOrder(player, 1);  // Coloca o player abaixo

        // label turno
        ImageIcon turnoPlayer = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menuJogador/turno.png"));
        JLabel turno = new JLabel(turnoPlayer);
        turno.setBounds(204, 28, 111, 53);
        turno.setOpaque(true);
        this.add(turno);

        // label quantidade de frutas ouro
        JLabel quantMaracuja = new JLabel();
        quantMaracuja.setBounds(200, 90, 80, 40);
        quantMaracuja.setOpaque(true);
        quantMaracuja.setBackground(Color.decode("#ffe414"));
        this.add(quantMaracuja);

        // label efeito antídoto(laranja)
        JLabel efeitoAntidoto = new JLabel();
        efeitoAntidoto.setBounds(200, 137, 80, 40);
        efeitoAntidoto.setOpaque(true);
        efeitoAntidoto.setBackground(Color.decode("#ff2727"));
        this.add(efeitoAntidoto);

        // label efeito agilidade(coco)
        JLabel efeitoAgilidade = new JLabel();
        efeitoAgilidade.setBounds(290, 90, 80, 40);
        efeitoAgilidade.setOpaque(true);
        efeitoAgilidade.setBackground(Color.decode("#2912f4"));
        this.add(efeitoAgilidade);

        // label efeito bichada
        JLabel efeitoBichada = new JLabel();
        efeitoBichada.setBounds(290, 137, 80, 40);
        efeitoBichada.setOpaque(true);
        efeitoBichada.setBackground(Color.decode("#bc0aa4"));
        this.add(efeitoBichada);

        // label jogador 1
        ImageIcon jogador1 = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menuJogador/jogador1.png"));
        JLabel jogador = new JLabel(jogador1);
        jogador.setBounds(17, 197, 161, 31);
        jogador.setOpaque(true);
        this.add(jogador);

        // label efeito força(abacate)
        ImageIcon forca = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/menuJogador/força.png"));
        JLabel efeitoForca = new JLabel(forca);
        efeitoForca.setBounds(204, 197, 164, 31);
        efeitoForca.setOpaque(true);
        this.add(efeitoForca);

        // botão consumir abacate
        ImageIcon consomeAbacate = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeAbacate.png"));
        JButton consumirAbacate = new JButton(consomeAbacate);
        consumirAbacate.setBounds(17, 239, 52, 55);
        consumirAbacate.setBorderPainted(false);
        consumirAbacate.setFocusPainted(false);
        consumirAbacate.setContentAreaFilled(false);
        this.add(consumirAbacate);
        consumirAbacate.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir acerola
        ImageIcon consomeAcerola = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeAcerola.png"));
        JButton consumirAcerola = new JButton(consomeAcerola);
        consumirAcerola.setBounds(69, 239, 52, 55); // Posição e tamanho do botão
        consumirAcerola.setBorderPainted(false);
        consumirAcerola.setFocusPainted(false);
        consumirAcerola.setContentAreaFilled(false);
        this.add(consumirAcerola);
        consumirAcerola.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir amora
        ImageIcon consomeAmora = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeAmora.png"));
        JButton consumirAmora = new JButton(consomeAmora);
        consumirAmora.setBounds(121, 239, 52, 55);
        consumirAmora.setBorderPainted(false);
        consumirAmora.setFocusPainted(false);
        consumirAmora.setContentAreaFilled(false);
        this.add(consumirAmora);
        consumirAmora.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir coco
        ImageIcon consomeCoco = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeCoco.png"));
        JButton consumirCoco = new JButton(consomeCoco);
        consumirCoco.setBounds(173, 239, 52, 55);
        consumirCoco.setBorderPainted(false);
        consumirCoco.setFocusPainted(false);
        consumirCoco.setContentAreaFilled(false);
        this.add(consumirCoco);
        consumirCoco.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir goiaba
        ImageIcon consomeGoiaba = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeGoiaba.png"));
        JButton consumirGoiaba = new JButton(consomeGoiaba);
        consumirGoiaba.setBounds(225, 239, 52, 55);
        consumirGoiaba.setBorderPainted(false);
        consumirGoiaba.setFocusPainted(false);
        consumirGoiaba.setContentAreaFilled(false);
        this.add(consumirGoiaba);
        consumirGoiaba.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir laranja
        ImageIcon consomeLaranja = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeLaranja.png"));
        JButton consumirLaranja = new JButton(consomeLaranja);
        consumirLaranja.setBounds(277, 239, 52, 55);
        consumirLaranja.setBorderPainted(false);
        consumirLaranja.setFocusPainted(false);
        consumirLaranja.setContentAreaFilled(false);
        this.add(consumirLaranja);
        consumirLaranja.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir maracujá
        ImageIcon consomeMaracuja = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consomeMaracuja.png"));
        JButton consumirMaracuja = new JButton(consomeMaracuja);
        consumirMaracuja.setBounds(329, 239, 52, 55);
        consumirMaracuja.setBorderPainted(false);
        consumirMaracuja.setFocusPainted(false);
        consumirMaracuja.setContentAreaFilled(false);
        this.add(consumirMaracuja);
        consumirMaracuja.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        // botão consumir fruta
        ImageIcon consumir = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/consumir.png"));
        JButton consumirFruta = new JButton(consumir);
        consumirFruta.setBounds(17, 305, 354, 46);
        consumirFruta.setBorderPainted(false);
        consumirFruta.setFocusPainted(false);
        consumirFruta.setContentAreaFilled(false);
        this.add(consumirFruta);
        consumirFruta.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        controle = true;

        // botão jogarDados
        ImageIcon dados = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/dados.png"));
        JButton jogarDados = new JButton(dados);
        jogarDados.setBounds(17, 384, 127, 76);
        //jogarDados.setBorderPainted(false);
        jogarDados.setFocusPainted(false);
        jogarDados.setContentAreaFilled(false);
        this.add(jogarDados);
        jogarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle == true) {
                    partida.jogarDados();
                    setControle(false);
                }
            }
        });

        //botão passar a vez
        ImageIcon pularVez = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/pularVez.png"));
        JButton passarVez = new JButton(pularVez);
        passarVez.setBounds(151, 384, 219, 76);
        //passarVez.setBorderPainted(false);
        passarVez.setFocusPainted(false);
        passarVez.setContentAreaFilled(false);
        this.add(passarVez);
        passarVez.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setControle(true);
                partida.proximoTurno();
            }
        });

        //botão pegar fruta
        ImageIcon pegaFruta = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/pegaFruta.png"));
        JButton pegarFruta = new JButton(pegaFruta);
        pegarFruta.setBounds(17, 504, 127, 76);
        pegarFruta.setBorderPainted(false);
        pegarFruta.setFocusPainted(false);
        pegarFruta.setContentAreaFilled(false);
        this.add(pegarFruta);
        pegarFruta.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });

        //botão encrenca
        ImageIcon encrencar = new ImageIcon(getClass().getResource("/interfaceVisual/imagens/menuJogador/encrencar.png"));
        JButton encrenca = new JButton(encrencar);
        encrenca.setBounds(151, 504, 219, 76);
        encrenca.setBorderPainted(false);
        encrenca.setFocusPainted(false);
        encrenca.setContentAreaFilled(false);
        this.add(encrenca);
        encrenca.addActionListener(e -> {
            // Ação a ser executada quando o botão for clicado
        });
    }

    private void setControle(boolean valor) {
        controle = valor;
    }
}
