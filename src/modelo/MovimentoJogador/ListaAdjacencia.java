package modelo.MovimentoJogador;

import modelo.entidades.CelulaTerreno;
import modelo.entidades.Pedra;
import modelo.mapa.Mapa;
import modelo.tipos.Coordenada;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Essa classe é responsável por lidar com a matriz de adjacência para movimentação do player.
 */
public class ListaAdjacencia {
    /**
     * Guarda as informações do grafo. É estático pois como o mapa é único todas as instâncias devem conter a mesma lista.
     */
    private static HashMap<Coordenada, LinkedList<RelacaoPeso>> MapaDoGrafo = new HashMap<>();

    public ListaAdjacencia(Mapa mapa){
        preencherGrafo(mapa);
    }

    private void preencherGrafo(Mapa mapa) {
        int dimensaoDaFloresta = mapa.getDimensao();

        for (int i = 0; i < dimensaoDaFloresta; i++){
            for (int j = 0; j < dimensaoDaFloresta; j++){

                Coordenada coordenadaAtual = new Coordenada(j, i);
                LinkedList<RelacaoPeso> chaves = chavesValidas(coordenadaAtual, mapa);
                MapaDoGrafo.put(coordenadaAtual, chaves);
            }
        }
    }

    private LinkedList<RelacaoPeso> chavesValidas(Coordenada coordenadaAtual, Mapa mapa){

        LinkedList<RelacaoPeso> vizinhos = new LinkedList<>();
        int i = coordenadaAtual.getY();
        int j = coordenadaAtual.getX();

        if (i-1 > 0){
            Coordenada vizinho = new Coordenada(j, i-1);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (i+1 < mapa.getDimensao()){
            Coordenada vizinho = new Coordenada(j, i+1);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (j-1 > 0){
            Coordenada vizinho = new Coordenada(j-1, i);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }
        if (j+1 < mapa.getDimensao()){
            Coordenada vizinho = new Coordenada(j+1, i);
            vizinhos.add(gerarRelacaoPeso(vizinho, mapa));
        }

        return vizinhos;
    }


    private RelacaoPeso gerarRelacaoPeso(Coordenada vizinho, Mapa mapa){
        int peso = calcularPeso(mapa.mapaTools.celulaEm(vizinho));
        return new RelacaoPeso(vizinho, peso);
    }

    private int calcularPeso (CelulaTerreno celula){
        if (celula instanceof Pedra) return 2;
        return 1;
    }
}
