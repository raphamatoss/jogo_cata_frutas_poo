package interfaceVisual.componentes;

import javax.swing.*;
import java.awt.*;

/**
 * A classe {@code PainelInterfaceJogador} estende {@link JPanel} e é utilizada para representar a interface do jogador,
 * onde futuramente será exibido o menu do jogador.
 * Atualmente, o painel é configurado de forma temporária com um fundo azul e um layout absoluto.
 */
public class PainelInterfaceJogador extends JPanel {

    /**
     * Construtor padrão que inicializa o painel com configurações temporárias.
     * O painel tem fundo azul e está posicionado à direita do mapa com um layout absoluto.
     * No futuro, essa área será usada para o menu do jogador.
     */
    public PainelInterfaceJogador() {
        // Define o layout absoluto (null layout)
        setLayout(null);

        //define a cor do painel
        setBackground(Color.decode("#ef5c00")); // Temporário

        // Define as dimensões e posição do painel
        setBounds(624, 0, 400, 624);

        // label players
        ImageIcon players = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/players.png"));
        JLabel player = new JLabel(players);
        player.setSize(161, 149); // Ajusta para o tamanho desejado
        player.setBounds(17, 28, 161, 149); // Posição e tamanho do JLabel
        this.add(player);
        ImageIcon spritePlayer1 = new ImageIcon(this.getClass().getResource("/interfaceVisual/imagens/jogadores/spriteJogador1.png"));
        JLabel player1 = new JLabel(spritePlayer1);
        player1.setSize(151, 139);
        player1.setBounds(17, 28, 151, 139);
        this.add(player);
        this.add(player1);
        this.setComponentZOrder(player1, 0); // Coloca o player1 no topo
        this.setComponentZOrder(player, 1);  // Coloca o player abaixo

        // label quantidade de frutas ouro
        JLabel quantMaracuja = new JLabel();
        quantMaracuja.setBounds(199, 30, 74, 45);
        quantMaracuja.setOpaque(true);
        quantMaracuja.setBackground(Color.decode("#bc0aa4"));
        this.add(quantMaracuja);

        // label turno
        JLabel turno = new JLabel();
        turno.setBounds(199, 28, 74, 45);
        turno.setOpaque(true);
        turno.setBackground(Color.decode("#bc0aa4"));
        this.add(turno);

        // label quantidade de frutas ouro
        JLabel quantMaracuja = new JLabel();
        quantMaracuja.setBounds(199, 30, 74, 45);
        quantMaracuja.setOpaque(true);
        quantMaracuja.setBackground(Color.decode("#bc0aa4"));
        this.add(quantMaracuja);
    }
}
