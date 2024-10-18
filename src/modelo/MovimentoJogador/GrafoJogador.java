package modelo.MovimentoJogador;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Pedra;
import modelo.mapa.Mapa;
import modelo.tipos.Coordenada;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Essa classe é responsável por lidar com a matriz de adjacência para movimentação do player.
 */
public class GrafoJogador {
    /**
     * Guarda as informações do grafo. É estático pois como o mapa é único todas as instâncias devem conter a mesma lista.
     */
    private boolean grafoPreenchido;
    private static HashMap<Coordenada, LinkedList<RelacaoPeso>> MapaDoGrafo = new HashMap<>();
    private Integer MatrizCaminhos[][];

    public GrafoJogador(Mapa mapa){
        if (!grafoPreenchido) preencherGrafo(mapa);
        this.MatrizCaminhos = new Integer[mapa.getDimensao()][mapa.getDimensao()];
    }

    public void preencherMatriz(Mapa mapa, Coordenada coordenadaAtual) {
        // Inicializa a matriz com -1, indicando que ainda não foi visitada
        preencherMenosUm(this.MatrizCaminhos);

        // Lista de nós não visitados, contendo inicialmente a coordenada atual com peso 0
        PriorityQueue<RelacaoPeso> nosnaoVisitados = new PriorityQueue<>();
        nosnaoVisitados.add(new RelacaoPeso(coordenadaAtual, 0));

        // Enquanto houver nós não visitados
        while (!nosnaoVisitados.isEmpty()) {
            // Remove o primeiro nó da fila (FIFO)
            RelacaoPeso noAtual = nosnaoVisitados.poll();
            Coordenada coordenadaRelacao = noAtual.getCoordenada();
            int linha = coordenadaRelacao.getI();
            int coluna = coordenadaRelacao.getJ();
            int pesoAtual = noAtual.getPeso();     // Número de passos até este nó

            // Verifica se a posição na matriz pode ser atualizada
            if (MatrizCaminhos[linha][coluna] > pesoAtual || MatrizCaminhos[linha][coluna] == -1) {
                // Atualiza a matriz com o número mínimo
                MatrizCaminhos[linha][coluna] = pesoAtual;

                // Para cada coordenada adjacente válida, adiciona à lista de nós não visitados
                for (RelacaoPeso r : chavesValidas(coordenadaRelacao, mapa)) {
                    // Incrementa o peso (número de passos) para os nós vizinhos
                    nosnaoVisitados.add(new RelacaoPeso(r.getCoordenada(), pesoAtual + r.getPeso()));
                }
            }
        }
    }

    private void preencherGrafo(Mapa mapa) {
        int dimensaoDaFloresta = mapa.getDimensao();

        for (int i = 0; i < dimensaoDaFloresta; i++){
            for (int j = 0; j < dimensaoDaFloresta; j++){
                Coordenada coordenadaAtual = new Coordenada(i, j);
                LinkedList<RelacaoPeso> chaves = chavesValidas(coordenadaAtual, mapa);
                MapaDoGrafo.put(coordenadaAtual, chaves);
            }
        }
        this.grafoPreenchido = true;
    }

    private LinkedList<RelacaoPeso> chavesValidas(Coordenada coordenadaAtual, Mapa mapa){

        LinkedList<RelacaoPeso> vizinhos = new LinkedList<>();
        int i = coordenadaAtual.getI();
        int j = coordenadaAtual.getJ();

        if (i > 0){
            Coordenada vizinho = new Coordenada(i-1, j);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (i < mapa.getDimensao()-1){
            Coordenada vizinho = new Coordenada(i+1, j );
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (j > 0){
            Coordenada vizinho = new Coordenada(i, j-1);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (j < mapa.getDimensao()-1){
            Coordenada vizinho = new Coordenada(i, j+1);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        return vizinhos;
    }

    private void preencherMenosUm(Integer[][] matriz){
        for (Integer[] linha : MatrizCaminhos){
            Arrays.fill(linha, -1);
        }
    }

    private RelacaoPeso gerarRelacaoPeso(Coordenada vizinho, Mapa mapa){
        int peso = calcularPeso(mapa.mapaTools.celulaEm(vizinho));
        return new RelacaoPeso(vizinho, peso);
    }

    private int calcularPeso (CelulaTerreno celula){
        if (celula instanceof Pedra) return 2;
        else return 1;

    }

    public void printMatriz(){
        for (Integer[] linha : this.MatrizCaminhos){
            for (Integer distancia : linha){
                System.out.printf("| %3d ", distancia);
            }
            System.out.println("");
        }
    }
}
