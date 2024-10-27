package modelo.utils;

import modelo.entidades.Jogador;

import static java.lang.Math.*;

public class JogadorUtils {

    public static int frutasDerrubadas(Jogador jogadorAtacante, Jogador jogadorDefensor) {
        int fa = jogadorAtacante.getForca();
        int fd = jogadorDefensor.getForca();
        return  (int) (round(log2(fa+1)) - round(log2(fd+1)));
    }

    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
}
