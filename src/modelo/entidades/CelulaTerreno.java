package entidades;

public abstract class CelulaTerreno {

	private Jogador jogadorOcupante;

	public CelulaTerreno(){
		this.jogadorOcupante = null;
	}

	// getters & setters --------------------------------------------
	public Jogador getJogadorOcupante() {
		return jogadorOcupante;
	}
	public void setJogadorOcupante(Jogador jogadorOcupante) {
		this.jogadorOcupante = jogadorOcupante;}
	// -------------------------------------------------------------

}