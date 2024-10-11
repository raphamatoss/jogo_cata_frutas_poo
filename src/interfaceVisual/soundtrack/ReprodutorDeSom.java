package interfaceVisual.soundtrack;

import jaco.mp3.player.MP3Player;

import java.io.File;

/** Gerencia as mídias de som do programa, como a música e os efeitos sonoros.
 */
public class ReprodutorDeSom {
      private MP3Player player;
      private static MP3Player botaoPlayer;

    boolean isAtivo;

    /** O construtor recebe o caminho de um arquivo de áudio mp3 e toca ele em loop.
     * @param string
     */
    public ReprodutorDeSom(String string) {
        try{
            File file = new File(string);
            player = new MP3Player(file);
            player.setRepeat(true);
            player.play();

            isAtivo = true;}
        catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean valor) {
        isAtivo = valor;
    }

    /** Toca o som armazenado na classe em loop.
     */
    public void tocarSom() {
        player.setRepeat(true);
        player.play();
    }

    /** Recebe o caminho de um arquivo de som mp3 e o toca apenas uma vez.
     * @param caminho
     */
    public void tocarSom(String caminho) {
        try{
            new MP3Player(new File(caminho)).play();
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    /** Reproduz o efeito sonoro dos botões.
     */
    public static void tocarBotao() {
        try {
            botaoPlayer = new MP3Player(new File("./interfaceVisual/soundtrack/pressionarBotao.mp3"));
            botaoPlayer.play();
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    /** Pausa a música armazenada na classe.
     */
    public void pausarSom() {
        player.pause();
    }
 }
