package modelo.frutas;

import modelo.entidades.Fruta;
import modelo.utils.Efeitos;

import java.util.ArrayList;

/**
 * Representa uma fruta do tipo coco.
 *
 * Esta classe estende a classe Fruta e define um coco específico.
 * Um coco pode estar bichado e causar efeitos diferentes ao ser consumido.
 */
public class Coco extends Fruta {

    /**
     * Constrói um objeto Coco.
     *
     * @param bichada Indica se o coco está bichado.
     */
    public Coco(boolean bichada) {
        super(bichada, "co");
    }

    /**
     * Retorna uma lista com os efeitos causados pelo consumo do coco.
     *
     * Se o coco estiver bichado, o efeito de envenenamento será adicionado.
     * Em todos os casos, o efeito de aumento de velocidade será adicionado.
     * @return Uma lista com os efeitos causados pelo coco.
     */
    @Override
    public ArrayList<Efeitos> causarEfeito() {

        ArrayList<Efeitos> efeitos = new ArrayList<>();
        efeitos.add(Efeitos.VELOCIDADE); // Sempre aumenta a velocidade

        if (this.isBichada()){
            efeitos.add(Efeitos.ENVENENAMENTO);
        }

        return efeitos;
    }
}