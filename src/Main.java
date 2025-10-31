import HashMap.*;
import LeituraArquivo.*;

public class Main {
    public static void main(String[] args) {

        String caminhoArquivo = "src/LeituraArquivo/female_names.txt";

        HashMap map1 = new HashMapFunction1();
        HashMap map2 = new HashMapFunction2();

        System.out.println("Iniciando carregamento");

        long tempoInsercao1 = LeituraArquivo.carregarArquivo(caminhoArquivo, map1);
        long tempoInsercao2 = LeituraArquivo.carregarArquivo(caminhoArquivo, map2);

        System.out.println("\ntestes de busca...");
        long tempoBusca1 = LeituraArquivo.testarBusca(caminhoArquivo, map1);
        long tempoBusca2 = LeituraArquivo.testarBusca(caminhoArquivo, map2);
        System.out.println("Testes de busca finalizados.");


        System.out.println("  Tabela Hash 1 ");
        System.out.println("Tempo total de inserção: " + tempoInsercao1 + " ms");
        System.out.println("Tempo total de busca " + tempoBusca1 + " ms");
        System.out.println("Número total de colisões: " + map1.returnColisoes());
        System.out.println("\nDistribuição das chaves:");
        System.out.println(map1.qtdeBuckets());

        System.out.println("  Tabela Hash 2");
        System.out.println("Tempo total de inserção: " + tempoInsercao2 + " ms");
        System.out.println("Tempo total de busca: " + tempoBusca2 + " ms");
        System.out.println("Número total de colisões: " + map2.returnColisoes());
        System.out.println("\nDistribuição das chaves:");
        System.out.println(map2.qtdeBuckets());
    }
}