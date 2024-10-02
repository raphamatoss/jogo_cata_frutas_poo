package entidades;

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
        return ".";
    }
}