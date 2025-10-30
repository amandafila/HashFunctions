package HashMap;
import DLL.*;

public class HashMapFunction2 extends HashMap {
    private int nColisoes = 0;

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
        }else{
            nColisoes++;
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

    public int returnColisoes(){
        return nColisoes;
    }

    public String qtdeBuckets() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                resultado.append("Bucket ").append(i)
                        .append(": ").append(hashTable[i].getSize())
                        .append(" elementos\n");
            } else {
                resultado.append("Bucket ").append(i)
                        .append(": vazio\n");
            }
        }

        return resultado.toString();
    }
}
