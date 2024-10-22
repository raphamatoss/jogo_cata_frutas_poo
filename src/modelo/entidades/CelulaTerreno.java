package modelo.entidades;

import java.awt.*;

/**
 * Essa classe é o modelo que todos os elementos estáticos devem seguir.
 */
public abstract class CelulaTerreno {
	/**
	 * Refere-se ao jogador ocupante da posição. É necessário pois serve como forma de posicionar os jogadores e verificar as possibilidades de ação.
	 */
	private Jogador jogadorOcupante;
	private int peso;

	/**
	 * A princípio toda célula de terreno é uma célula livre para um jogador.
	 */
	public CelulaTerreno() {
		this.jogadorOcupante = null;
		this.peso = -1;
	}

	// TODO: E SE DOIS JOGADORES OCUPAREM A MESMA CÉLULA????? AQUI NÃO COBRE ESSE CASO
	public Jogador getJogadorOcupante() {
		return jogadorOcupante;
	}

	public void setJogadorOcupante(Jogador jogadorOcupante) {
		this.jogadorOcupante = jogadorOcupante;
	}

	public abstract Image toImage();
}
