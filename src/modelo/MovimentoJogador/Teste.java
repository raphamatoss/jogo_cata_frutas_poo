package modelo.MovimentoJogador;

import interfaceVisual.telas.Preview;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.mapa.Mapa;
import modelo.mapa.MapaConfiguracao;
import modelo.tipos.Coordenada;

import java.util.Stack;

public class Teste {
        public static void main(String[] args) {

            MapaConfiguracao configuracaoDoMapa = GerenciadorMapaArquivo.importarArquivoTerreno("./input.txt");
            assert configuracaoDoMapa != null;

            Mapa mapa = new Mapa(configuracaoDoMapa, 2);
            mapa.visualizarTerreno();

            //a dimensão do imput é 12.
            Coordenada coordenadaTeste = new Coordenada(9, 5);
            //Coordenada coordenadaTeste = mapa.getJogador(0).getCoordenada();
            Coordenada cTeste = mapa.getJogador(0).getCoordenada();
            GrafoJogador grafo = new GrafoJogador(mapa);
            grafo.preencherMatriz(mapa, cTeste);
            System.out.println("");
            grafo.printMatriz();


            Preview preview = new Preview(mapa);
            //preview.getPainelMapa().mostrarPesos(grafo.getMatrizCaminhos());

            System.out.println("");
            Stack<Coordenada> passos = grafo.passosAtePosicao(coordenadaTeste);
            while(!passos.isEmpty()){
                Coordenada.printCoordenada(passos.pop());
            }
        }
}
