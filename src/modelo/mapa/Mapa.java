package modelo.mapa;

import modelo.entidades.*;
import modelo.frutas.*;
import modelo.tipos.*;
import modelo.utils.Randomizador;

import java.util.ArrayList;
import java.util.Map;


public class Mapa {

    private final int dimensao;
    private final CelulaTerreno[][] floresta;
    private final ArrayList<Arvore> arvoresFloresta = new ArrayList<>();
    private final ArrayList<Jogador> jogadores = new ArrayList<>();


    public Mapa(MapaConfiguracao configuracaoDoMapa, int numeroJogadores) {
        this.dimensao = configuracaoDoMapa.dimensao;

        floresta = new CelulaTerreno[dimensao][dimensao];

        for (int i = 0; i < numeroJogadores; i++)
            this.jogadores.add(new Jogador("" + i));

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


    // Coordenadas Válidas -------------------------
    private Coordenada gerarCoordenadaValida() {
        boolean livre;
        int x, y;
        do {
            x = Randomizador.gerarInteiroAleatorio(0, dimensao - 1);
            y = Randomizador.gerarInteiroAleatorio(0, dimensao - 1);

            livre = floresta[x][y] instanceof Grama;
        } while (!livre);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaFruta() {
        int x, y;
        do {
            Coordenada c = gerarCoordenadaValida();
            x = c.getX();
            y = c.getY();
        } while (((Grama) floresta[x][y]).getFrutaOcupante() != null);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaJogador() {
        boolean livre;
        int x, y;
        do {
            //TODO: Verificar se o jogador pode ser gerado em cima de pedras e árvores e frutas no chão.
            Coordenada c = gerarCoordenadaValidaFruta();
            x = c.getX();
            y = c.getY();
            livre = floresta[x][y].getJogadorOcupante() == null;
        } while (!livre);
        return new Coordenada(x, y);
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
            Coordenada c = gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Pedra();
        }
    }

    private void posicionarArvores(Map<String, QuantidadeFrutas> FrutaMap) {
        int qtdArvore = quantidadeTotalArvores(FrutaMap);
        for (int i = 0; i < qtdArvore; i++) {
            Coordenada c = gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Arvore();
            arvoresFloresta.add((Arvore) floresta[c.getX()][c.getY()]);
        }
    }

    // ---------------------------------------------------------
    private boolean decidirBichada(int probabilidade) {
        return Randomizador.sortearTrue(probabilidade);
        // Separada em uma função para caso sofra alteração.
    }

    private Fruta gerarFrutaPorTipo(String fruta, boolean bichada) {
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

    public CelulaTerreno celulaEm(Coordenada c) {
        CelulaTerreno[] linha = floresta[c.getX()];
        CelulaTerreno celula = linha[c.getY()];
        return celula;
    }

    private void posicionarFrutas(Map<String, QuantidadeFrutas> quantidadeFrutasMap, int probabilidadeBichada) {

        // Para cada conjunto de <String, quantidades <Arvore, Grama>>
        for (Map.Entry<String, QuantidadeFrutas> entry : quantidadeFrutasMap.entrySet()) {

            // Para cada quantidade na grama
            boolean bichada = decidirBichada(probabilidadeBichada);
            Fruta fruta = gerarFrutaPorTipo(entry.getKey(), bichada);

            for (int i = 0; i < (entry.getValue()).grama; i++) {
                CelulaTerreno celula = celulaEm(gerarCoordenadaValidaFruta());
                Grama grama = (Grama) celula;
                grama.setFrutaOcupante(fruta);
            }
        }
    }

    private void posicionarJogador(Jogador jogador) {
        // valores para posicionar o jogador
        Coordenada c = gerarCoordenadaValidaJogador();
        floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
    }

    private void posicionarJogadores(ArrayList<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            posicionarJogador(jogador);
        }
    }

    public void selecionarFrutadasArvores(Map<String, QuantidadeFrutas> frutasMap) {

        int arvore = 0;
        for (Map.Entry<String, QuantidadeFrutas> entry : frutasMap.entrySet()) {

            if (entry.getKey().equals("maracuja")) continue;
            Fruta frutaModelo = gerarFrutaPorTipo(entry.getKey(), false);

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

    public void printarCelula(CelulaTerreno celula) {
        String celulaStr = celula.toString();

        System.out.print(String.format("%-2s", celulaStr)); // Ajusta à esquerda para garantir o alinhamento
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
}