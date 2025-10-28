import HashMap.*;

public class Main {
    public static void main(String[] args) {

        HashMapFunction2 map = new HashMapFunction2();
        System.out.println(map.hashFunction("carlos"));
        System.out.println(map.hashFunction("Amanda"));
        System.out.println(map.hashFunction("Mateus"));

        map.put("carlos");
        map.put("Amanda");
        map.put("Mateus");

        System.out.println(map.get("carlos"));
        System.out.println(map.get("Amanda"));
        System.out.println(map.get("Mateus"));
    }
}