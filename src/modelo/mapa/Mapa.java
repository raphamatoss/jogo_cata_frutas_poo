package modelo.mapa;

import modelo.entidades.*;
import modelo.tipos.*;
import modelo.utils.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Essa classe configura e contém a floresta na qual o jogo ocorre.
 */
public class Mapa {

    /**
     * Dimensão do mapa.
     */
    private final int dimensao;

    /**
     * Matriz de células de terreno que serão configuradas dentro dos parâmentros do arquivo.
     */
    private final CelulaTerreno[][] floresta;

    /**
     * Array que contém as referências para as arvores da floresta.
     *
     * @see Mapa#selecionarFrutadasArvores
     */
    private final ArrayList<Arvore> arvoresFloresta = new ArrayList<>();

    /**
     * Array com as referências para os jogadores.
     */
    private final ArrayList<Jogador> jogadores = new ArrayList<>();

    /**
     * Instância de mapaTools que contém a floresta do próprio mapa, para executar algoritimos de mnipulação com o mapa.
     *
     * @see utils.MapaTools
     */
    private MapaTools mapaTools;


    /**
     * Construtor inicializa a dimensao, a floresta, os jogadores, com base nos valores dados pela configuração do mapa.
     *
     * @param configuracaoDoMapa Configuração do mapa, já configurada e verificada, contendo as informações necessárias para cirar uma floresta.
     * @param numeroJogadores Numero de jogadores.
     */
    public Mapa(MapaConfiguracao configuracaoDoMapa, int numeroJogadores) {
        this.dimensao = configuracaoDoMapa.dimensao;
        floresta = new CelulaTerreno[dimensao][dimensao];
        this.mapaTools = new MapaTools(floresta, dimensao);
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

    /**
     * Esse método preenche a floresta com gramas.
     */
    private void posicionarGramas() {
        for (CelulaTerreno[] line : floresta) {
            for (int i = 0; i < line.length; i++) {
                line[i] = new Grama();  // Criando uma nova instância de Grama para cada célula
            }
        }
    }

    /**
     * Dada uma quantidade de pedras, posiciona elas aleatoriamente pelo mapa.
     *
     * @param qtdPedras Quantidade de pedras a serem colocadas.
     */
    private void posicionarPedras(int qtdPedras) {
        for (int i = 0; i < qtdPedras; i++) {
            Coordenada c = mapaTools.gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Pedra();
        }
    }

    /**
     * Posiciona arvores em posições livres.
     */
    private void posicionarArvores(Map<String, QuantidadeFrutas> FrutaMap) {
        int qtdArvore = quantidadeTotalArvores(FrutaMap);
        for (int i = 0; i < qtdArvore; i++) {
            Coordenada c = mapaTools.gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Arvore();
            arvoresFloresta.add((Arvore) floresta[c.getX()][c.getY()]);
        }
    }

    /**
     * Posiciona as frutas no chão, conforme um mapa de nomes para quantidades.
     *
     * @param FrutaMap Mapa de nomes para quantidades.
     * @param probabilidadeBichada Porcentagem contendo a chance de que as frutas geradas no chão sejam bichadas. 
     */
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

    /**
     * Posiciona um jogador.
     */
    private void posicionarJogador(Jogador jogador) {
        // valores para posicionar o jogador
        Coordenada c = mapaTools.gerarCoordenadaValidaJogador();
        floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
    }

    /**
     * Posiciona os jogadores.
     */
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

    /**
     * Seleciona de qual tipo cada árvore da floresta será.
     *
     * @param frutasMap Mapa de nomes para quantidades.
     */
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

    /**
     * Principal método da classe Mapa. Este método é responsável por executar da maneira correta todos os passos anteriores, garantindo a geração de um mapa íntegro e completo conforme as descrições da configuracaoDoMapa.
     *
     * @param configuracao MapaConfiguracao que será usado de referênca para a criação deste mapa.
     *
     * @see MapaConfiguracao
     */
    private void carregarTerreno(MapaConfiguracao configuracao) {

        posicionarGramas();
        posicionarPedras(configuracao.qtdPedras);
        posicionarArvores(configuracao.qntFrutasPorTipo);
        posicionarFrutas(configuracao.qntFrutasPorTipo, configuracao.probabilidadeBichadas);
        selecionarFrutadasArvores(configuracao.qntFrutasPorTipo);
        posicionarJogadores(this.jogadores);

    }

    /**
     * vizualiza o terreno atual no terminal.
     */
    public void visualizarTerreno(){
        mapaTools.visualizarTerreno();
    }

    /**
     * Gera uma string completa do mapa. Pode ser usada para serialização ou até mesmo para trasnformação em imagens.
     */
    @Override
    public String toString(){
        return mapaTools.FlorestaToString();
    }
}
