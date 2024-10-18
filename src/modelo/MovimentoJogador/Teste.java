package modelo.MovimentoJogador;

import interfaceVisual.telasStatePattern.Preview;
import modelo.arquivo.GerenciadorMapaArquivo;
import modelo.mapa.Mapa;
import modelo.mapa.MapaConfiguracao;
import modelo.tipos.Coordenada;

public class Teste {
        public static void main(String[] args) {

            MapaConfiguracao configuracaoDoMapa = GerenciadorMapaArquivo.importarArquivoTerreno("./input.txt");
            assert configuracaoDoMapa != null;

            Mapa mapa = new Mapa(configuracaoDoMapa, 2);
            mapa.visualizarTerreno();

            // Acabei de descobrir que as coordenadas estão com a interpretação invertida.
            //a dimensão do imput é 12.
            //Coordenada coordenadaTeste = new Coordenada(5, 5);
            Coordenada coordenadaTeste = mapa.getJogador(0).getCoordenada();
            Coordenada cTeste = new Coordenada(coordenadaTeste.getI(), coordenadaTeste.getJ());
            GrafoJogador grafo = new GrafoJogador(mapa);
            grafo.preencherMatriz(mapa, cTeste);
            grafo.printMatriz();

            Preview preview = new Preview(mapa);
            //preview.getPainelMapa().mostrarPesos(grafo.getMatrizCaminhos());
        }
}
