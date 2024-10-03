package modelo.utils;

import modelo.entidades.Fruta;
import modelo.frutas.*;

public class FrutaTools {

    static public Fruta gerarFruta(String fruta, boolean bichada) {
        switch (fruta) {
            case "maracuja" -> {
                return new Maracuja(bichada);
            }
            case "laranja" -> {
                return new Laranja(bichada);
            }
            case "abacate" -> {
                return new Abacate(bichada);
            }
            case "coco" -> {
                return new Coco(bichada);
            }
            case "acerola" -> {
                return new Acerola(bichada);
            }
            case "amora" -> {
                return new Amora(bichada);
            }
            case "goiaba" -> {
                return new Goiaba(bichada);
            }
        }
        return null;
    }

    public static boolean decidirBichada(int probabilidade) {
        return Randomizador.sortearTrue(probabilidade);
    }
}
