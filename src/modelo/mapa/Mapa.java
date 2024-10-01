package terreno;

import entidades.*;
import frutas.*;
import tipos.*;
import utils.Frutas;
import utils.Random;
import utils.Verificador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Mapa {

    private final int dimensao;
    private final CelulaTerreno[][] floresta;
    private final ArrayList<Arvore> arvoresFloresta = new ArrayList<>();;
    private final ArrayList<Jogador> jogadores =  new ArrayList<>();


    public Mapa(MapaConfiguracao configuracaoDoMapa, int numeroJogadores) {

        this.dimensao = configuracaoDoMapa.dimensao;
        floresta = new CelulaTerreno[dimensao][dimensao];
        for (int i=0; i<numeroJogadores; i++) this.jogadores.add(new Jogador("" + i));
        carregarTerreno(configuracaoDoMapa);

    }


    // getters -----------------------------------------
    public int getDimensao() {return dimensao;}
    public CelulaTerreno[][] getFloresta() {return floresta;}
    public ArrayList<Arvore> getArvoresFloresta() {return arvoresFloresta;}
    // ------------------------------------------------


    // Coordenadas Válidas -------------------------
    private Coordenada gerarCoordenadaValida(){
        boolean livre;
        int x, y;
        do {
            x = Random.gerarInteiroAleatorio(0, dimensao - 1);
            y = Random.gerarInteiroAleatorio(0, dimensao - 1);

            livre = floresta[x][y] instanceof Grama;
        } while (!livre);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaFruta(){
        int x, y;
        do{
            Coordenada c = gerarCoordenadaValida();
            x = c.getX(); y = c.getY();
        }while (( (Grama) floresta[x][y]).getFrutaOcupante() != null);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaJogador(){
        boolean livre;
        int x, y;
        do {
            x = Random.gerarInteiroAleatorio(0, dimensao - 1);
            y = Random.gerarInteiroAleatorio(0, dimensao - 1);

            livre = floresta[x][y].getJogadorOcupante() == null;
        } while (!livre);
        return new Coordenada(x, y);
    }
   // ---------------------------------------------------------
  
    

   // Posicionar Elementos ------------------------------------
    private void posicionarGramas() {
        for (CelulaTerreno[] line : floresta) {
            Arrays.fill(line, new Grama());
        }
    }


    private void posicionarPedras(int qtdPedras) {
        for (int i = 0; i < qtdPedras; i++) {
            Coordenada c = gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Pedra();
        }
    }

    private void posicionarArvores(Map<Frutas, QuantidadeFrutas> FrutaMap) {
        int qtdArvore = 0;
        for (Map.Entry<Frutas, QuantidadeFrutas> entry : FrutaMap.entrySet()){
            qtdArvore+= entry.getValue().arvore;
        }
        for (int i = 0; i < qtdArvore; i++) {
            Coordenada c = gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Arvore();
        }
    }

   // ---------------------------------------------------------



    private boolean decidirBichada(int probabilidade){
        return Random.sortearTrue(probabilidade);
        // Separada em uma função para caso sofra alteração.
    }

    private Fruta gerarFrutaPorTipo(Frutas f, boolean bichada){
        switch (f){
            case MARACUJA -> {
                return new Maracuja(bichada);
            }
            case LARANJA -> {
                return new Laranja(bichada);
            }
            case ABACATE -> {
                return new Abacate(bichada);
            }
            case COCO -> {
                return new Coco(bichada);
            }
            case ACEROLA -> {
                return new Acerola(bichada);
            }
            case AMORA -> {
                return new Amora(bichada);
            }
            case GOIABA -> {
                return new Goiaba(bichada);
            }
        }
        return null;
    }

    private void posicionarFrutas(Map<Frutas, QuantidadeFrutas> quantidadeFrutasMap, int probabilidadeBichada) {

            // Para cada conjunto de <Frutas, quantidades <Arvore, Grama>>
            for (Map.Entry<Frutas, QuantidadeFrutas> entry : quantidadeFrutasMap.entrySet()) {
                // Para cada quantidade na grama
                for (int i = 0; i < entry.getValue().grama; i++) {
                    Coordenada c = gerarCoordenadaValidaFruta();
                    boolean bichada = decidirBichada(probabilidadeBichada);
                    Fruta fruta = gerarFrutaPorTipo(entry.getKey(), bichada);
                    //TODO: Tratar o caso em que a fruta retornada é nula, apesar de que acho qeu esse caso nunca ocorre.
                    ((Grama) floresta[c.getX()][c.getY()]).setFrutaOcupante(fruta);
                }
            }
    }

    private void posicionarJogador (Jogador jogador) {
        // valores para posicionar o jogador
        Coordenada c = gerarCoordenadaValidaJogador();
        floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
    }

    private void posicionarJogadores (ArrayList<Jogador> jogadores) {
        // valores para posicionar o jogador
        for(Jogador jogador : jogadores) {
            Coordenada c = gerarCoordenadaValidaJogador();
            floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
        }
    }


    private void carregarTerreno(MapaConfiguracao configuracao) {

        posicionarGramas();
        posicionarPedras(configuracao.qtdPedras);
        posicionarArvores(configuracao.qntFrutasPorTipo);
        posicionarFrutas(configuracao.qntFrutasPorTipo,configuracao.probabilidadeBichadas);
        posicionarJogadores(this.jogadores);

    }

    //TODO: Corrigir.
    public void visualizarTerreno() {
        final int larguraCelula = 5;

        for (CelulaTerreno[] linha : floresta) {
            for (CelulaTerreno celula : linha) {
                String representacao = "?"; // Estou inicializando a variável com "?" que sinaliza que um elemento estranho apareceu no mapa

                if (Verificador.isGrama(celula)) {
                    // A célula é uma Grama
                    if (Verificador.temFrutaNaGrama(celula) && Verificador.temJogadorNaGrama(celula)) {
                        // Possui Jogador e Fruta -> Jogador/Fruta
                        representacao = celula.getJogadorOcupante().toString() + "/" + ((Grama) celula).getFrutaOcupante().toString();
                    } else if (Verificador.temFrutaNaGrama(celula)) {
                        // Possui apenas Fruta
                        representacao = ((Grama) celula).getFrutaOcupante().toString();
                    } else if(Verificador.temJogadorNaGrama(celula)) {
                        // Possui apenas Jogador
                        representacao = celula.getJogadorOcupante().toString();
                    } else {
                        // Grama desocupada.
                        representacao = celula.toString();
                    }
                } else if (Verificador.isPedra(celula)) {
                    // A célula é uma Pedra
                    if (Verificador.temJogadorNaPedra(celula)) {
                        // Possui um Jogador encima da Pedra
                        representacao = celula.getJogadorOcupante().toString() + "/" + celula;
                    } else {
                        // Pedra desocupada.
                        representacao = celula.toString();
                    }
                } else if (Verificador.isArvore(celula)) {
                    // A célula é uma Arvore
                    if (Verificador.temJogadorNaArvore(celula)) {
                        // Possui um Jogador em baixo da Arvore.
                        representacao = celula.getJogadorOcupante().toString() + "/" + celula;
                    } else {
                        // Arvore desocupada.
                        representacao = celula.toString();
                    }
                }

                // Ajusta a largura da representação para a largura fixa da célula
                System.out.printf("%-" + larguraCelula + "s", representacao); // %-3s: uma String com largura fixa de 3 unidades
            }
            System.out.println();
        }
    }

}
