package modelo.mapa;

import java.util.HashMap;
import java.util.Map;

import modelo.tipos.QuantidadeFrutas;

public class MapaConfiguracao {

    protected int dimensao;
    protected int qtdPedras;
    public Map<String, QuantidadeFrutas> qntFrutasPorTipo = new HashMap<>();
    protected int probabilidadeBichadas;
    protected int tamanhoMochila;

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }
    public void setQtdPedras(int qtdPedras){
        this.qtdPedras = qtdPedras;
    }

    public void setProbabilidadeBichadas(int probabilidadeBichadas) {
        this.probabilidadeBichadas = probabilidadeBichadas;
    }

    public void setTamanhoMochila(int tamanhoMochila) {
        this.tamanhoMochila = tamanhoMochila;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("dimensao ").append(dimensao).append("\n");
        sb.append("pedras ").append(qtdPedras).append("\n");
        
        for (Map.Entry<String, QuantidadeFrutas> entry : qntFrutasPorTipo.entrySet()) {
            sb.append(entry.getKey()).append(" ")
              .append(entry.getValue().grama).append(" ")
              .append(entry.getValue().arvore).append("\n");
        }
        
        sb.append("bichadas ").append(probabilidadeBichadas).append("\n");
        sb.append("mochila ").append(tamanhoMochila);
        
        return sb.toString();
    }
}