package modelo.arquivo;

import java.util.Random;

/**
 * A classe {@code VerificadorMapaArquivo} é responsável por gerenciar e verificar as configurações de um mapa que
 * contém frutas, pedras e outros objetos. Esta classe define e controla a distribuição de elementos no mapa, como
 * frutas de ouro, frutas diversas e pedras, além de verificar o espaço disponível e ajustar os valores conforme
 * necessário.
 */
public class VerificadorMapaArquivo {

    private int dimensao;
    private int frutasOuroChao;
    private int frutasOuroASurgir;
    private int frutasOuroTotais;
    private int frutasDiversas;
    private int chanceBichada;
    private int pedras;
    private int tamanhoMochila;
    private int arvCoco;
    private int arvLaranja;
    private int arvAbacate;
    private int arvAmora;
    private int arvAcerola;
    private int arvGoiaba;
    private int coco;
    private int laranja;
    private int abacate;
    private int amora;
    private int acerola;
    private int goiaba;
    private int espacoDisponivel;

    private static Random random = new Random(System.currentTimeMillis());

    /**
     * Construtor padrão que inicializa o mapa com valores padrão e calcula o espaço disponível com base nos
     * elementos iniciais.
     */
	public VerificadorMapaArquivo() {
        dimensao = 5;
        espacoDisponivel = dimensao*dimensao;

        pedras = 3;
        arvCoco = 1;
        arvLaranja = 1;
        arvAbacate = 1;
        arvAmora = 1;
        arvAcerola = 1;
        arvGoiaba = 1;

        frutasOuroChao = 1;
        frutasOuroASurgir = 2;
        frutasOuroTotais = frutasOuroChao + frutasOuroASurgir;

        frutasDiversas = 8;
        distribuirFrutas();

        chanceBichada = 25;

        tamanhoMochila = frutasOuroTotais/2 + 1;

        espacoDisponivel = espacoDisponivel - (pedras + arvLaranja + arvAbacate +
                arvAmora + arvAcerola + arvGoiaba + arvCoco + frutasOuroChao + frutasDiversas) - 2;
    }

    /**
     * Retorna a dimensão atual do mapa.
     *
     * @return a dimensão do mapa.
     */
    public int getDimensao() {
        return dimensao;
    }

    /**
     * Define uma nova dimensão para o mapa. O valor da dimensão deve estar entre 5 e 12, e o espaço disponível
     * deve ser suficiente para a nova dimensão.
     *
     * @param dimensao a nova dimensão desejada.
     * @return {@code true} se a nova dimensão for válida e for possível aplicar; {@code false} caso contrário.
     */
    public boolean setDimensao(int dimensao) {
        if (dimensao < 5 || dimensao > 12)
            return false;
        else if (dimensao < this.dimensao && espacoDisponivel < (this.dimensao*this.dimensao - dimensao*dimensao)) {
            return false;
        }
        else {
            if (dimensao < this.dimensao) {
                espacoDisponivel = espacoDisponivel - (this.dimensao*this.dimensao - dimensao*dimensao);
            }
            else {
                espacoDisponivel = espacoDisponivel + (2*dimensao - 1);
            }
            this.dimensao = dimensao;
            return true;
        }
    }


    /**
     * Retorna a quantidade de frutas de ouro no chão.
     *
     * @return a quantidade de frutas de ouro no chão.
     */
    public int getFrutasOuroChao() {
        return frutasOuroChao;
    }


    /**
     * Define a quantidade de frutas de ouro no chão. O valor deve ser maior ou igual a zero e não pode exceder
     * o espaço disponível.
     *
     * @param frutasOuroChao a nova quantidade de frutas de ouro no chão.
     * @return {@code true} se o valor for válido e a alteração puder ser feita; {@code false} caso contrário.
     */
    public boolean setFrutasOuroChao(int frutasOuroChao) {
        if (espacoDisponivel < 1 && frutasOuroChao > this.frutasOuroChao)
            return false;
        else if(frutasOuroChao < 0)
            return false;
        else if (frutasOuroChao == 0 && frutasOuroTotais == 0)
            return false;
        else {
            if (frutasOuroChao < this.frutasOuroChao) {
                espacoDisponivel++;
                frutasOuroTotais--;
            }
            else {
                espacoDisponivel--;
                frutasOuroTotais++;
            }
            this.frutasOuroChao = frutasOuroChao;
            return true;
        }
    }

    /**
     * Retorna a quantidade de frutas de ouro que irão surgir.
     *
     * @return a quantidade de frutas de ouro a surgir.
     */
    public int getFrutasOuroASurgir() {
        return frutasOuroASurgir;
    }

    /**
     * Define a quantidade de frutas de ouro que irão surgir no futuro. O valor deve ser maior ou igual a zero.
     *
     * @param frutasOuroASurgir a nova quantidade de frutas de ouro a surgir.
     * @return {@code true} se o valor for válido e a alteração puder ser feita; {@code false} caso contrário.
     */
    public boolean setFrutasOuroASurgir(int frutasOuroASurgir) {
        if (frutasOuroASurgir < 0)
            return false;
        else if (frutasOuroASurgir == 0 && frutasOuroTotais == 0)
            return false;
        else {
            if (frutasOuroASurgir < this.frutasOuroASurgir)
                frutasOuroTotais--;
            else
                frutasOuroTotais++;
            this.frutasOuroASurgir = frutasOuroASurgir;
            return true;
        }
    }

    /**
     * Retorna a quantidade total de frutas de ouro no mapa (somatório das frutas de ouro no chão e as que irão surgir).
     *
     * @return a quantidade total de frutas de ouro.
     */
    public int getFrutasOuroTotais() {
        frutasOuroTotais = frutasOuroChao + frutasOuroASurgir;
        return frutasOuroTotais;
    }

    /*
    public void setFrutasOuroTotais(int frutasOuroTotais) {
        this.frutasOuroTotais = frutasOuroTotais;
    }
     */

    /**
     * Retorna a quantidade de frutas diversas no mapa.
     *
     * @return a quantidade de frutas diversas.
     */
    public int getFrutasDiversas() {
        return frutasDiversas;
    }

    /**
     * Define a quantidade de frutas diversas no mapa. O valor deve ser maior ou igual a zero e não pode exceder
     * o espaço disponível.
     *
     * @param frutasDiversas a nova quantidade de frutas diversas.
     * @return {@code true} se o valor for válido e a alteração puder ser feita; {@code false} caso contrário.
     */
    public boolean setFrutasDiversas(int frutasDiversas) {
        if (espacoDisponivel < 1 && frutasDiversas > this.frutasDiversas)
            return false;
        else if (frutasDiversas < 0)
            return false;
        else {
            if (frutasDiversas < this.frutasDiversas)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.frutasDiversas = frutasDiversas;
            switch (random.nextInt(6)) {
                case(0):
                    laranja++;
                    break;
                case(1):
                    abacate++;
                    break;
                case(2):
                    coco++;
                    break;
                case(3):
                    acerola++;
                    break;
                case(4):
                    amora++;
                    break;
                case(5):
                    goiaba++;
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    // Métodos semelhantes para chanceBichada, pedras, árvores, e distribuição de frutas seguem a mesma lógica.
    // Os métodos set verificam as condições para ajuste e retornam verdadeiro ou falso com base na validade da operação.

    /**
     * Distribui aleatoriamente as frutas diversas entre os diferentes tipos de frutas.
     */
    public int getChanceBichada() {
        return chanceBichada;
    }

    public boolean setChanceBichada(int chanceBichada) {
        if (chanceBichada < 0 || chanceBichada > 100)
            return false;
        else {
            this.chanceBichada = chanceBichada;
            return true;
        }
    }

    public int getPedras() {
        return pedras;
    }

    /**
     * Define a quantidade de pedras no mapa. O valor deve ser maior ou igual a zero e não pode exceder
     * o espaço disponível.
     *
     * @param pedras a nova quantidade de frutas diversas.
     * @return {@code true} se o valor for válido e a alteração puder ser feita; {@code false} caso contrário.
     */
    public boolean setPedras(int pedras) {
        if (espacoDisponivel < 1 && pedras > this.pedras)
            return false;
        else if (pedras < 0)
            return false;
        else {
            if (pedras < this.pedras)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.pedras = pedras;
            return true;
        }
    }

    /** Verifica o tamanho mínimo da mochila de acordo com as regras do jogo.
     *
     * @param frutasOuroTotais
     * @param tamanhoMochila
     * @return boolean
     */
    public boolean verificarTamanhoMinimo(int frutasOuroTotais, int tamanhoMochila) {
        int aux = frutasOuroTotais/2 + 1;
        if (tamanhoMochila < aux) {
            this.tamanhoMochila = (frutasOuroTotais/2)+1;
            return true;
        }
        return false;
    }

    public int getTamanhoMochila() {
        return tamanhoMochila;
    }

    public boolean setTamanhoMochila(int tamanhoMochila) {
        if (tamanhoMochila < (frutasOuroTotais/2 + 1)) {
            return false;
        }
        this.tamanhoMochila = tamanhoMochila;
        return true;
    }

    public int getArvCoco() {
        return arvCoco;
    }

    public boolean setArvCoco(int arvCoco) {
        if (espacoDisponivel < 1 && arvCoco > this.arvCoco)
            return false;
        else if (arvCoco < 0)
            return false;
        else {
            if (arvCoco < this.arvCoco)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvCoco = arvCoco;
            return true;
        }
    }

    public int getArvLaranja() {
        return arvLaranja;
    }

    public boolean setArvLaranja(int arvLaranja) {
        if (espacoDisponivel < 1 && arvLaranja > this.arvLaranja)
            return false;
        else if (arvLaranja < 0)
            return false;
        else {
            if (arvLaranja < this.arvLaranja)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvLaranja = arvLaranja;
            return true;
        }
    }

    public int getArvAbacate() {
        return arvAbacate;
    }

    public boolean setArvAbacate(int arvAbacate) {
        if (espacoDisponivel < 1 && arvAbacate > this.arvAbacate)
            return false;
        else if (arvAbacate < 0)
            return false;
        else {
            if (arvAbacate < this.arvAbacate)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvAbacate = arvAbacate;
            return true;
        }
    }

    public int getArvAmora() {
        return arvAmora;
    }

    public boolean setArvAmora(int arvAmora) {
        if (espacoDisponivel < 1 && arvAmora > this.arvAmora)
            return false;
        else if (arvAmora < 0)
            return false;
        else {
            if (arvAmora < this.arvAmora)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvAmora = arvAmora;
            return true;
        }
    }

    public int getArvAcerola() {
        return arvAcerola;
    }

    public boolean setArvAcerola(int arvAcerola) {
        if (espacoDisponivel < 1 && arvAcerola > this.arvAcerola)
            return false;
        else if (arvAcerola < 0)
            return false;
        else {
            if (arvAcerola < this.arvAcerola)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvAcerola = arvAcerola;
            return true;
        }
    }

    public int getArvGoiaba() {
        return arvGoiaba;
    }

    public boolean setArvGoiaba(int arvGoiaba) {
        if (espacoDisponivel < 1 && arvGoiaba > this.arvGoiaba)
            return false;
        else if (arvGoiaba < 0)
            return false;
        else {
            if (arvGoiaba < this.arvGoiaba)
                espacoDisponivel++;
            else
                espacoDisponivel--;
            this.arvGoiaba = arvGoiaba;
            return true;
        }
    }

    public int getEspacoDisponivel() {
        return espacoDisponivel;
    }

    public void setEspacoDisponivel(int espacoDisponivel) {
        this.espacoDisponivel = espacoDisponivel;
    }

    public int getCoco() {
        return coco;
    }

    public int getLaranja() {
        return laranja;
    }

    public int getAbacate() {
        return abacate;
    }

    public int getAmora() {
        return amora;
    }

    public int getAcerola() {
        return acerola;
    }

    public int getGoiaba() {
        return goiaba;
    }

    public void distribuirFrutas() {
        for (int i = 0; i < frutasDiversas; i++) {
            switch (random.nextInt(6)) {
                case(0):
                    laranja++;
                    break;
                case(1):
                    abacate++;
                    break;
                case(2):
                    coco++;
                    break;
                case(3):
                    acerola++;
                    break;
                case(4):
                    amora++;
                    break;
                case(5):
                    goiaba++;
                    break;
                default:
                    break;
            }
        }
    }
}
