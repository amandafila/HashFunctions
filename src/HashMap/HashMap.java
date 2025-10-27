package HashMap;
import DLL.*;


public abstract class HashMap {
    protected DLL<String>[] hashTable;

    public HashMap() {
        this.hashTable = (DLL<String>[]) new DLL[32];
    }

    public abstract int hashFunction(String key);

    public abstract void put(String key, Object value);

    public abstract Object get(String key);

    public abstract void remove(String key);

}
