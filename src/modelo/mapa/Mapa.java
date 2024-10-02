package modelo.mapa;

import modelo.entidades.*;
import modelo.frutas.*;
import modelo.tipos.*;
import modelo.utils.Randomizador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Mapa {

    private final int dimensao;
    private CelulaTerreno[][] floresta;
    private final ArrayList<Arvore> arvoresFloresta = new ArrayList<>();
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
            x = Randomizador.gerarInteiroAleatorio(0, dimensao - 1);
            y = Randomizador.gerarInteiroAleatorio(0, dimensao - 1);

            livre = floresta[x][y] instanceof Grama;
        } while (!livre);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaFruta(){
        int x, y;
        do{
            Coordenada c = gerarCoordenadaValida();
            x = c.getX();
            y = c.getY();
        }while (((Grama) floresta[x][y]).getFrutaOcupante() != null);
        return new Coordenada(x, y);
    }

    private Coordenada gerarCoordenadaValidaJogador(){
        boolean livre;
        int x, y;
        do {
        	//TODO: Verificar se o jogador pode ser gerado em cima de pedras e árvores e frutas no chão.
            Coordenada c = gerarCoordenadaValidaFruta();
            x = c.getX(); y = c.getY();
            livre = floresta[x][y].getJogadorOcupante() == null;
        } while (!livre);
        return new Coordenada(x, y);
    }
   // ---------------------------------------------------------
  
    

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
        int qtdArvore = 0;
        for (Map.Entry<String, QuantidadeFrutas> entry : FrutaMap.entrySet()){
            if(entry.getKey() == "maracuja") continue;
            qtdArvore+= entry.getValue().arvore;
        }
        for (int i = 0; i < qtdArvore; i++) {
            Coordenada c = gerarCoordenadaValida();
            floresta[c.getX()][c.getY()] = new Arvore();
            arvoresFloresta.add((Arvore) floresta[c.getX()][c.getY()]);
        }
    }

   // ---------------------------------------------------------



    private boolean decidirBichada(int probabilidade){
        return Randomizador.sortearTrue(probabilidade);
        // Separada em uma função para caso sofra alteração.
    }

    private Fruta gerarFrutaPorTipo(String fruta, boolean bichada){
        switch (fruta){
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

    public CelulaTerreno celulaEm (Coordenada c){
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

    private void posicionarJogador (Jogador jogador) {
        // valores para posicionar o jogador
        Coordenada c = gerarCoordenadaValidaJogador();
        floresta[c.getX()][c.getY()].setJogadorOcupante(jogador);
    }

    private void posicionarJogadores (ArrayList<Jogador> jogadores) {
        for(Jogador jogador : jogadores) {
            posicionarJogador(jogador);
        }
    }

    public void selecionarFrutadasArvores(Map<String, QuantidadeFrutas> quantidadeFrutasMap) {

        //Mantenha como está. A lógica faz sentido.
        // LEMBRAR DE IMPLEMENTAR O DECIDIR BICHADA QUANDO A FRUTA É GERADA PELA ÁRVORE.
        int aSetadasFloresta=0;
    	for(Map.Entry<String, QuantidadeFrutas> entry : quantidadeFrutasMap.entrySet()){
            Fruta frutaModelo = gerarFrutaPorTipo(entry.getKey(), false);
            for(int aSetadas=0; aSetadas<entry.getValue().arvore;aSetadas++) {
                arvoresFloresta.get(aSetadasFloresta).setFrutaDaArvore(frutaModelo);
                aSetadasFloresta++;
            }
        }
    }

    private void carregarTerreno(MapaConfiguracao configuracao) {

        posicionarGramas();
        posicionarPedras(configuracao.qtdPedras);
        posicionarArvores(configuracao.qntFrutasPorTipo);    // erro, arvores maracuja n existem (CHECAR SOLUÇÂO)
        posicionarFrutas(configuracao.qntFrutasPorTipo,configuracao.probabilidadeBichadas);  // erro, parece que frutas do mesmo tipo são adicionadas em todas as linhas do mapa
        selecionarFrutadasArvores(configuracao.qntFrutasPorTipo);
        posicionarJogadores(this.jogadores);     // erro -> gerar coordenada valida jogador, parece haver um looping infinito

    }
    
    public void printarCelula(CelulaTerreno celula) {
    	System.out.print(celula);
    }
    
    public void printarLinha(CelulaTerreno[] linha) {
    	System.out.print("\\ ");
    	for(CelulaTerreno celula : linha) {
    		printarCelula(celula);
    	}
        System.out.println(" ");
    }
 
    public void visualizarTerreno() {
    	for(CelulaTerreno[] linha : floresta) {
    		printarLinha(linha);
    	}
    }

}
