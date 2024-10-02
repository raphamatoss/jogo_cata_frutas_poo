package modelo.arquivo;

import modelo.tipos.QuantidadeFrutas;

import java.util.Random;

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
    private int espacoDisponivel;

    //private static Random random = new Random(42);

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

        chanceBichada = 25;

        tamanhoMochila = frutasOuroTotais/2 + 1;

        espacoDisponivel = espacoDisponivel - (pedras + arvLaranja + arvAbacate +
                arvAmora + arvAcerola + arvGoiaba + arvCoco + frutasOuroChao + frutasDiversas);
    }

    public int getDimensao() {
        return dimensao;
    }

    public boolean setDimensao(int dimensao) {
        if (dimensao < 5 || dimensao > 20)
            return false;
        else {
            int aux = dimensao*dimensao;
            espacoDisponivel = espacoDisponivel + (2*dimensao - 1);
            this.dimensao = dimensao;
            return true;
        }
    }

    public int getFrutasOuroChao() {
        return frutasOuroChao;
    }

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

    public int getFrutasOuroASurgir() {
        return frutasOuroASurgir;
    }

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

    public int getFrutasOuroTotais() {
        frutasOuroTotais = frutasOuroChao + frutasOuroASurgir;
        return frutasOuroTotais;
    }

    /*
    public void setFrutasOuroTotais(int frutasOuroTotais) {
        this.frutasOuroTotais = frutasOuroTotais;
    }
     */

    public int getFrutasDiversas() {
        return frutasDiversas;
    }

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
            return true;
        }
    }

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

    public void setArvCoco(int arvCoco) {
        this.arvCoco = arvCoco;
    }

    public int getArvLaranja() {
        return arvLaranja;
    }

    public void setArvLaranja(int arvLaranja) {
        this.arvLaranja = arvLaranja;
    }

    public int getArvAbacate() {
        return arvAbacate;
    }

    public void setArvAbacate(int arvAbacate) {
        this.arvAbacate = arvAbacate;
    }

    public int getArvAmora() {
        return arvAmora;
    }

    public void setArvAmora(int arvAmora) {
        this.arvAmora = arvAmora;
    }

    public int getArvAcerola() {
        return arvAcerola;
    }

    public void setArvAcerola(int arvAcerola) {
        this.arvAcerola = arvAcerola;
    }

    public int getArvGoiaba() {
        return arvGoiaba;
    }

    public void setArvGoiaba(int arvGoiaba) {
        this.arvGoiaba = arvGoiaba;
    }

    public int getEspacoDisponivel() {
        return espacoDisponivel;
    }

    public void setEspacoDisponivel(int espacoDisponivel) {
        this.espacoDisponivel = espacoDisponivel;
    }
}
