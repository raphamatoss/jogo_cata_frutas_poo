package modelo.mapa;

import modelo.entidades.*;
import modelo.tipos.*;
import modelo.utils.*;
import java.util.ArrayList;
import java.util.Map;


public class Mapa {

    private final int dimensao;
    private final CelulaTerreno[][] floresta;
    private final ArrayList<Arvore> arvoresFloresta = new ArrayList<>();
    private final ArrayList<Jogador> jogadores = new ArrayList<>();
    private MapaTools mapaTools;


    public Mapa(MapaConfiguracao configuracaoDoMapa, int numeroJogadores) {
        this.dimensao = configuracaoDoMapa.dimensao;
        floresta = new CelulaTerreno[dimensao][dimensao];
        this.mapaTools = new MapaTools(floresta, dimensao-1);
        for (int i = 0; i < numeroJogadores; i++)
            this.jogadores.add(new Jogador("" + (i+1)));
        carregarTerreno(configuracaoDoMapa);
    }


    // getters -----------------------------------------
    public int getDimensao() {
        return dimensao;
    }

    public CelulaTerreno[][] getFloresta() {
        return floresta;
    }

    public ArrayList<Arvore> getArvoresFloresta() {
        return arvoresFloresta;
    }
    // ------------------------------------------------


    // Posicionar Elementos ------------------------------------

    private void posicionarGramas() {
        for (CelulaTerreno[] line : floresta) {
            for (int i = 0; i < line.length; i++) {
                line[i] = new Grama();  // Criando uma nova instância de Grama para cada célula
            }
        }
    }

    private void posicionarPedras(int qtdPedras) {
        for (int i = 0; i < qtdPedras; i++) {
            Coordenada c = mapaTools.gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Pedra();
        }
    }

    private void posicionarArvores(Map<String, QuantidadeFrutas> FrutaMap) {
        int qtdArvore = quantidadeTotalArvores(FrutaMap);
        for (int i = 0; i < qtdArvore; i++) {
            Coordenada c = mapaTools.gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Arvore();
            arvoresFloresta.add((Arvore) floresta[c.getX()][c.getY()]);
        }
    }

    private void posicionarFrutas(Map<String, QuantidadeFrutas> FrutaMap, int probabilidadeBichada) {

        for (Map.Entry<String, QuantidadeFrutas> entry : FrutaMap.entrySet()) {
            Fruta fruta = FrutaTools.gerarFruta(entry.getKey(), FrutaTools.decidirBichada(probabilidadeBichada));
            int frutasNaGrama = entry.getValue().grama;
            for (int i = 0; i < frutasNaGrama; i++) {
                Coordenada coordenadaValida = mapaTools.gerarCoordenadaValidaFruta();
                Grama grama = (Grama) mapaTools.celulaEm(coordenadaValida);
                grama.setFrutaOcupante(fruta);
            }
        }
    }

    private void posicionarJogador(Jogador jogador) {
        // valores para posicionar o jogador
        Coordenada c = mapaTools.gerarCoordenadaValidaJogador();
        floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
    }

    private void posicionarJogadores(ArrayList<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            posicionarJogador(jogador);
        }
    }

    // ---------------------------------------------------------

    public int quantidadeTotalArvores(Map<String, QuantidadeFrutas> FrutaMap){
        int qtdArvore = 0;
        for (Map.Entry<String, QuantidadeFrutas> entry : FrutaMap.entrySet()) {
            if (entry.getKey().equals("maracuja")) continue;
            else qtdArvore += entry.getValue().arvore;
        }
        return qtdArvore;
    }

    public void selecionarFrutadasArvores(Map<String, QuantidadeFrutas> frutasMap) {

        int arvore = 0;
        for (Map.Entry<String, QuantidadeFrutas> entry : frutasMap.entrySet()) {

            if (entry.getKey().equals("maracuja")) continue;
            Fruta frutaModelo = FrutaTools.gerarFruta(entry.getKey(), false);

            for (int fruta = 0; fruta < entry.getValue().arvore; fruta++) {
                arvoresFloresta.get(arvore).setFrutaDaArvore(frutaModelo);
                arvore++;
            }
        }
    }

    private void carregarTerreno(MapaConfiguracao configuracao) {

        posicionarGramas();
        posicionarPedras(configuracao.qtdPedras);
        posicionarArvores(configuracao.qntFrutasPorTipo);
        posicionarFrutas(configuracao.qntFrutasPorTipo, configuracao.probabilidadeBichadas);
        selecionarFrutadasArvores(configuracao.qntFrutasPorTipo);
        posicionarJogadores(this.jogadores);

    }

    public void visualizarTerreno(){
        mapaTools.visualizarTerreno();
    }

    @Override
    public String toString(){
        return mapaTools.FlorestaToString();
    }
}
