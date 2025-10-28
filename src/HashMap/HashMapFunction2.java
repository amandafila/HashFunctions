package HashMap;
import DLL.*;

public class HashMapFunction2 extends HashMap {

    @Override
    public int hashFunction(String key) {
        Contagem contagem = new Contagem();
        int produto = contagem.somaPesosVogaisMaisConsoantes(key);
        return produto;
    }

    @Override
    public void put(String key) {
        int valor =  hashFunction(key);
        if (hashTable[valor] == null) {
            hashTable[valor] = new DLL();
        }
        hashTable[valor].add(key);
    }

    @Override
    public Object get(String key) {
        int valor =  hashFunction(key);
        if (hashTable[valor] != null) {
            return valor;
        }else{
            System.out.println("Elemento não encontrado");
            return null;
        }
    }

    @Override
    public void remove(String key) {
        int valor =  hashFunction(key);
        if (hashTable[valor] != null) {
            hashTable[valor].remove(key);
        }else{
            System.out.println("Elemento não encontrado");
        }
    }
}
