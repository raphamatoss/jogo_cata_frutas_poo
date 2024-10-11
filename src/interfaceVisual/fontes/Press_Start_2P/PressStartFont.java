package interfaceVisual.fontes.Press_Start_2P;

import java.awt.*;
import java.io.InputStream;

/** Gerencia a configuração da fonte externa Press_Start_2P.
 */
public class PressStartFont {
    private Font pressStart;

    /** O construtor inicializa a fonte pelo caminho do arquivo dela e define algumas configurações padrão.
     */
    public PressStartFont() {
        try {
            InputStream is = getClass().getResourceAsStream("./PressStart2P-Regular.ttf");
            pressStart = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 8);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** O construtor com o size recebe um valor inteiro e inicializa a fonte com o tamanho = size.
     * @param size
     */
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

    /** Define o tamanho da fonte
     * @param tamanho
     */
    public void setFontSize(int tamanho) {
        pressStart.deriveFont(Font.PLAIN, tamanho);
    }
}
