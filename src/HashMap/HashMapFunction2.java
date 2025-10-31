package HashMap;
import DLL.*;

public class HashMapFunction2 extends HashMap {


    @Override
    public int calculateHash(String key) {
        Contagem contagem = new Contagem();
        return contagem.somaPesosVogaisMaisConsoantes(key);
    }
}
