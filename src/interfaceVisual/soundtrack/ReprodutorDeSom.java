package interfaceVisual.soundtrack;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class ReprodutorDeSom {
      MP3Player player;
      MP3Player playerBotao;

    boolean isAtivo;
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

    public void tocarSom() {
        player.setRepeat(true);
        player.play();
    }

    public void tocarSom(String caminho) {
        try{
            new MP3Player(new File(caminho)).play();
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    public void tocarBotao() {
        try {
            new MP3Player(new File("./interfaceVisual/soundtrack/pressionarBotao.mp3")).play();
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    public void pausarSom() {
        player.pause();
    }
 }
