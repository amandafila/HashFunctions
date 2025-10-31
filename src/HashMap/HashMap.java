package HashMap;
import DLL.*;

public abstract class HashMap {
    protected DLL<String>[] hashTable;
    protected int size;
    protected int capacity;
    protected int nColisoes;

    protected static final double LOAD_FACTOR_THRESHOLD = 0.75;

    public HashMap() {
        this.capacity = 32; // Capacidade inicial
        this.hashTable = (DLL<String>[]) new DLL[this.capacity];
        this.size = 0;
        this.nColisoes = 0;
    }

    public abstract int calculateHash(String key);

    public int hashFunction(String key) {
        int rawHash = calculateHash(key);
        return Math.abs(rawHash % this.capacity);
    }

    protected void rehash() {
        DLL<String>[] oldTable = this.hashTable;
        int oldCapacity = this.capacity;

        this.capacity = oldCapacity * 2;
        this.hashTable = (DLL<String>[]) new DLL[this.capacity];
        this.size = 0;
        this.nColisoes = 0;

        System.out.println("REHASHING: Capacidade aumentada para " + this.capacity);

        for (int i = 0; i < oldCapacity; i++) {
            if (oldTable[i] != null) {
                for (int j = 0; j < oldTable[i].getSize(); j++) {
                    String keyToRehash = oldTable[i].get(j);
                    this.put(keyToRehash);
                }
            }
        }
    }

    public void put(String key) {
        if ((double) this.size / this.capacity >= LOAD_FACTOR_THRESHOLD) {
            rehash();
        }

        int valor = hashFunction(key);
        if (hashTable[valor] == null) {
            hashTable[valor] = new DLL();
        } else {
            nColisoes++;
        }
        hashTable[valor].add(key);
        size++;
    }

    public Object get(String key) {
        int valor = hashFunction(key);
        if (hashTable[valor] != null) {
            return valor;
        } else {
            System.out.println("Elemento não encontrado");
            return null;
        }
    }

    public void remove(String key) {
        int valor = hashFunction(key);
        if (hashTable[valor] != null) {
            boolean removed = hashTable[valor].remove(key);
            if(removed) {
                size--;
            }
        } else {
            System.out.println("Elemento não encontrado");
        }
    }

    public int returnColisoes() {
        return nColisoes;
    }

    public String qtdeBuckets() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < this.capacity; i++) {
            if (hashTable[i] != null && hashTable[i].getSize() > 0) {
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