package modelo.MovimentoJogador;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Pedra;
import modelo.mapa.Mapa;
import modelo.tipos.Coordenada;

import java.util.*;

/**
 * Essa classe é responsável por lidar com o grafo da implementação da movimentação do player.
 */
public class GrafoJogador {

    /**
     * Dimensão do mapa em que será calculada a matriz de menor caminho.
     */
    private int dimensao;

    /**
     * Mapa que guarda um mapa de cada nó para seus nós adjacentes em uma fila de prioridade.
     */
    private HashMap<Coordenada, PriorityQueue<RelacaoPeso>> MapaDoGrafo = new HashMap<>();

    /**
     * Matriz que guarda a distância mínima de cada célula para as outras.
     */
    private Integer MatrizCaminhos[][];

    /**
     * O construtor recebe um mapa e gera o mapa de adjacência e a Matriz de caminhos.
     * @param mapa Mapa que será utilizado de referência para gerar o grafo.
     */
    public GrafoJogador(Mapa mapa){
        preencherGrafo(mapa);
        this.MatrizCaminhos = new Integer[mapa.getDimensao()][mapa.getDimensao()];
        this.dimensao = mapa.getDimensao();
    }

    /**
     * Preenche a matriz de valores mínimos.
     * @param mapa Mapa de referência, deve ser o mesmo que o preencher grafo.
     * @param coordenadaAtual Coordenada de referência para calculo relativo.
     */
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
            int pesoAtual = noAtual.getPeso();     // Número de passos até este nó

            // Verifica se a posição na matriz pode ser atualizada
            if (getvalorPosMatriz(coordenadaRelacao) > pesoAtual || getvalorPosMatriz(coordenadaRelacao) == -1) {
                // Atualiza a matriz com o número mínimo
                setvalorPosMatriz(coordenadaRelacao, pesoAtual);

                // Para cada coordenada adjacente válida, adiciona à lista de nós não visitados
                for (RelacaoPeso r : chavesValidas(coordenadaRelacao, mapa)) {
                    // Incrementa o peso (número de passos) para os nós vizinhos
                    nosnaoVisitados.add(new RelacaoPeso(r.getCoordenada(), pesoAtual + r.getPeso()));
                }
            }
        }
    }

    /**
     * Preenche o grafo do mapa com todos os caminhos existentes.
     * @param mapa Mapa de referência.
     */
    private void preencherGrafo(Mapa mapa) {
        int dimensaoDaFloresta = mapa.getDimensao();

        for (int i = 0; i < dimensaoDaFloresta; i++){
            for (int j = 0; j < dimensaoDaFloresta; j++){
                Coordenada coordenadaAtual = new Coordenada(i, j);
                PriorityQueue<RelacaoPeso> chaves = chavesValidas(coordenadaAtual, mapa);
                MapaDoGrafo.put(coordenadaAtual, chaves);
            }
        }
    }

    /**
     * Método para retornar os vizinhos válidos e seus respectivos pesos. Importante no preenchimento do mapa do grafo.
     * @param coordenadaAtual Coordenada de referência de onde serão retornados os vizinhos.
     * @param mapa Mapa de referência de onde a coordenada pertence.
     * @return Retorna uma lista de Relaçoes/peso para os vizinhos da coordenada dada.
     */
    public PriorityQueue<RelacaoPeso> chavesValidas(Coordenada coordenadaAtual, Mapa mapa){

        PriorityQueue<RelacaoPeso> vizinhos = new PriorityQueue<>();
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

    /**
     * Printa a matriz de caminhos no terminal.
     */
    public void printMatriz(){
        int i = 0;
        for (Integer[] linha : this.MatrizCaminhos){
            System.out.print(i + " ");
            for (Integer distancia : linha){
                System.out.printf("| %3d ", distancia);
            }
            System.out.println("");
            i++;
        }
    }

    /**
     * Retorna uma pilha com os passos de uma coordenada até outra pelo menor caminho.
     * @param destino Coordenada de destino
     * @return Retorna uma pilha Origem -> Nó2 -> ... -> Nó destino.
     */
    public Stack<Coordenada> passosAtePosicao(Coordenada destino){

        Stack<Coordenada> passos = new Stack<>();
        //O destino deve ser o último a ser lido.
        passos.push(destino);

        //Enquanto não encontramos a origem, navegue entre os menores vizinhos.
        Coordenada atual = destino;
        while(getvalorPosMatriz(atual) != 0){
            PriorityQueue<RelacaoPeso> vizinhosPorMenorCaminho = new PriorityQueue<>();
            int i = atual.getI();
            int j = atual.getJ();

            //Adiciona os vizinhos numa fila de prioridade em relação ao valor da coordenada na matriz.
            if (i > 0){
                Coordenada vizinho = new Coordenada(i-1, j);
                vizinhosPorMenorCaminho.add(new RelacaoPeso(vizinho, getvalorPosMatriz(vizinho)));
            }
            if (i < dimensao-1){
                Coordenada vizinho = new Coordenada(i+1, j);
                vizinhosPorMenorCaminho.add(new RelacaoPeso(vizinho, getvalorPosMatriz(vizinho)));
            }
            if (j > 0){
                Coordenada vizinho = new Coordenada(i, j-1);
                vizinhosPorMenorCaminho.add(new RelacaoPeso(vizinho, getvalorPosMatriz(vizinho)));
            }
            if (j < dimensao-1){
                Coordenada vizinho = new Coordenada(i, j+1);
                vizinhosPorMenorCaminho.add(new RelacaoPeso(vizinho, getvalorPosMatriz(vizinho)));
            }
            //Retorna o menor dos vizinhos e adiciona ele na pilha.
            RelacaoPeso menorVizinho = vizinhosPorMenorCaminho.poll();
            atual = menorVizinho.getCoordenada();
            passos.push(atual);
        }
        return passos;
    }

    private int getvalorPosMatriz(Coordenada coordenada){
        return MatrizCaminhos[coordenada.getI()][coordenada.getJ()];
    }

    private void setvalorPosMatriz(Coordenada c, int valor){
        MatrizCaminhos[c.getI()][c.getJ()] = valor;
    }
}
