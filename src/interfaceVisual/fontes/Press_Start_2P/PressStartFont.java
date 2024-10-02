package interfaceVisual.fontes.Press_Start_2P;

import java.awt.*;
import java.io.InputStream;

public class PressStartFont {
    private Font pressStart;
    public PressStartFont() {
        try {
            InputStream is = getClass().getResourceAsStream("./PressStart2P-Regular.ttf");
            pressStart = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 8);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PressStartFont(int size) {
        try {
            InputStream is = getClass().getResourceAsStream("./PressStart2P-Regular.ttf");
            pressStart = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, size);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Font getFont() {
        return pressStart;
    }

    public void setFontSize(int tamanho) {
        pressStart.deriveFont(Font.PLAIN, tamanho);
    }
}
