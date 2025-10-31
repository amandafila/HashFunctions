package HashMap;
import DLL.*;

public class HashMapFunction1 extends HashMap {


    @Override
    public int calculateHash(String key) {
        Contagem contagem = new Contagem();
        return contagem.produtoVogaisConsoantes(key);
    }
}
