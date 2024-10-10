package modelo.utils;

import modelo.entidades.Arvore;
import modelo.entidades.CelulaTerreno;
import modelo.entidades.Grama;
import modelo.tipos.Coordenada;
import java.util.Random;

/*
   -> A ideia dessa classe é simplificar e generalizar algumas funções úteis ao se trabalhar com o mapa do jogo
   -> Ela funciona como um util.Scanner que é necessário instanciar um objeto dela com o mapa em questão.
   -> Será útil quando precisarmos por exemplo colocar as frutas no chão após serem derrubadas, podemos criar um subconjunto
   -> da floresta e instanciar um objeto dessa classe, e usar as funções dentro dos limites alternativos.
 */

public class MapaTools {

    private CelulaTerreno[][] floresta;
    int dimensao;

    public MapaTools(CelulaTerreno[][] floresta, int dimensao){
        this.floresta = floresta;
        this.dimensao = dimensao;
    }

    public CelulaTerreno celulaEm(Coordenada c) {
        CelulaTerreno[] linha = floresta[c.getX()];
        return linha[c.getY()];
    }

    // GerarCoordenadas ----------------------------------------------------

    public Coordenada gerarCoordenada(){
        Random r = new Random();
        int x, y;
        x = r.nextInt(dimensao);
        y = r.nextInt(dimensao);
        return new Coordenada(x, y);
    }

    public Coordenada gerarCoordenadaValida() {
        boolean livre;
        Coordenada c;
        do {
            c = gerarCoordenada();
            livre = celulaEm(c) instanceof Grama;
        } while (!livre);
        return c;
    }

    public Coordenada gerarCoordenadaValidaFruta() {
        Coordenada c;
        do {
             c = gerarCoordenadaValida();
        } while (((Grama) celulaEm(c)).getFrutaOcupante() != null);
        return c;
    }

    public Coordenada gerarCoordenadaValidaJogador() {
        boolean livre;
        Coordenada c;
        do {
            c = gerarCoordenada();
            livre = celulaEm(c).getJogadorOcupante() == null && !(celulaEm(c) instanceof Arvore);
        } while (!livre);
        return c;
    }
    // -----------------------------------------------------------------------



    // Visualização no terminal ----------------------------------------------
    public void printarCelula(CelulaTerreno celula) {
        String celulaStr = celula.toString();

        System.out.print(String.format("%-3s", celulaStr)); // Ajusta à esquerda para garantir o alinhamento
    }

    public void printarLinha(CelulaTerreno[] linha) {
        for (CelulaTerreno celula : linha) {
            printarCelula(celula);
            System.out.print(" | "); // Separador entre as células
        }
    }

    public void visualizarTerreno() {
        // Imprime cada linha com o índice da linha correspondente
        for (int i = 0; i < dimensao; i++) {
            System.out.printf("%3d | ", i); // Impressão do índice da linha

            // Imprime as células da linha
            CelulaTerreno[] linha = floresta[i];

            printarLinha(linha);

            System.out.println();
        }
    }
    // ------------------------------------------------------------




    //TODO: Verificar se a forma de string pode ser útil na geração do gráfico e alterá-la confome necessário

    // Retorno Como String ------------------------------------------
    public String formatarCelula(CelulaTerreno celula) {
        String celulaStr = celula.toString();
        return String.format("%-2s", celulaStr);
    }

    public String formatarLinha(CelulaTerreno[] linha) {
        StringBuilder linhaBuilder = new StringBuilder();
        for (CelulaTerreno celula : linha) {
            linhaBuilder.append(formatarCelula(celula));
            linhaBuilder.append(" | "); // Adiciona o separador entre as células
        }
        return linhaBuilder.toString(); // Retorna a linha formatada
    }

    public String FlorestaToString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < dimensao; i++) {
                builder.append(String.format("%3d | ", i));

                CelulaTerreno[] linha = floresta[i];

                builder.append(formatarLinha(linha));
                builder.append("\n");
            }
            return builder.toString();
    }
    // ------------------------------------------------------------
}
