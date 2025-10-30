import HashMap.*;
import LeituraArquivo.*;

public class Main {
    public static void main(String[] args) {

        HashMapFunction1 map = new HashMapFunction1();

        LeituraArquivo.carregarArquivo("src/LeituraArquivo/female_names.txt", map);

        System.out.println(map.returnColisoes());
        System.out.println(map.qtdeBuckets());
    }
}