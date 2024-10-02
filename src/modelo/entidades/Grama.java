package modelo.entidades;

public class Grama extends CelulaTerreno {

    public Fruta frutaOcupante;


    public Grama() {
        super();
        this.frutaOcupante = null;
    }


    // getters & setters ---------------------------------------
    public Fruta getFrutaOcupante() {
        return frutaOcupante;
    }
    public void setFrutaOcupante(Fruta frutaOcupante) {
        this.frutaOcupante = frutaOcupante;
    }
    // ---------------------------------------------------------


    @Override
    public String toString() {
        //Corrigir, fiz na pressa.
        if(this.getJogadorOcupante() != null && frutaOcupante == null){
            return " " + getJogadorOcupante() + " ";
        }
        else if (this.getJogadorOcupante() != null && frutaOcupante != null){
            return " " + getJogadorOcupante() + frutaOcupante + " ";
        }
        else if (frutaOcupante != null){
            return " " + frutaOcupante + " ";
        }
        else return "  .  ";
    }
}
