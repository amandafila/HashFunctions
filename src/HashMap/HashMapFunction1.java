package HashMap;
import DLL.*;

public class HashMapFunction1 extends HashMap {

    @Override
    public int hashFunction(String key) {
        Contagem contagem = new Contagem();
        int produto = contagem.produtoVogaisConsoantes(key);
        return produto;
    }

    @Override
    public void put(String key, Object value) {
        int valor =  hashFunction(key);
        if (hashTable[valor] == null) {
            hashTable[valor] = new DLL();
        }
        hashTable[valor].add(key);
    }

    @Override
    public Object get(String key) {return null;}

    @Override
    public void remove(String key) {}
}
