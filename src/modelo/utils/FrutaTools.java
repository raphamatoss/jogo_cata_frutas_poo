package modelo.utils;

import modelo.entidades.Fruta;
import modelo.frutas.*;
/**
 * A classe FrutaTools contém métodos de caráter genérico para lidar com 
 * objetos da classe Fruta.
 *
 * @see Fruta
 */
public class FrutaTools {
    /**
     * O método gerarFruta é utilizado para dada um nome, gerar uma instância
     * da fruta correspondente.
     *
     * @param fruta String correspondente ao nome da fruta.
     * @param bichada boolean correspondente à qualidade da fruta. false -> não bichada, true -> bichada.
     *
     * Utilizada em grande parte na classe {@link modelo.mapa.Mapa}
     */
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
    /**
     * Esse método recebe a probabilidade de uma fruta ser bichada e dentro das
     * chances decide a qualidade da fruta.
     *
     * @param probabilidade inteiro [0-100] referente a probabilidade desejada. 
     */
    public static boolean decidirBichada(int probabilidade) {
        return Randomizador.sortearTrue(probabilidade);
    }
}
