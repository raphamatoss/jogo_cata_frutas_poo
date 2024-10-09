package modelo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Essa classe é responsável por associar cada grupo de caracteres do mapa à sua
 * respectiva imagem.
 */
public class MapEntidadeImagem {

    /**
     * Mapa que guarda as referências por chave dos arquivos de imagem.
     */
    private Map<String, String> map;

    /**
     * Construtor que inicializa o mapa com os valores fixos.
     */
    public MapEntidadeImagem() {
        map = new HashMap<String, String>();
        map.put("ac", "file://$PROJECT_DIR$/interfaceVisual/imagens/blocos/acerola.png");
    }
}
