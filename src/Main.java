import HashMap.*;
import LeituraArquivo.*;

public class Main {
    public static void main(String[] args) {

        String caminhoArquivo = "src/LeituraArquivo/female_names.txt"; // (Source: 28)

        // 1. Inicialização das duas tabelas hash [cite: 19, 25]
        HashMap map1 = new HashMapFunction1();
        HashMap map2 = new HashMapFunction2();

        System.out.println("Iniciando carregamento e testes...");

        // 2. Inserção e medição de tempo [cite: 29, 41]
        long tempoInsercao1 = LeituraArquivo.carregarArquivo(caminhoArquivo, map1);
        long tempoInsercao2 = LeituraArquivo.carregarArquivo(caminhoArquivo, map2);

        // 3. Teste de eficiência de Busca
        System.out.println("\nIniciando testes de busca...");
        long tempoBusca1 = LeituraArquivo.testarBusca(caminhoArquivo, map1);
        long tempoBusca2 = LeituraArquivo.testarBusca(caminhoArquivo, map2);
        System.out.println("Testes de busca finalizados.");

        // 4. Relatório Final [cite: 21, 44]
        System.out.println("\n--- RELATÓRIO FINAL COMPARATIVO ---");

        // --- Relatório Tabela 1 ---
        System.out.println("\n==============================================");
        System.out.println("  Tabela Hash 1 (produtoVogaisConsoantes)");
        System.out.println("==============================================");
        System.out.println("Tempo total de inserção: " + tempoInsercao1 + " ms"); // [cite: 45]
        System.out.println("Tempo total de busca (todos os nomes): " + tempoBusca1 + " ms"); // [cite: 45]
        System.out.println("Número total de colisões: " + map1.returnColisoes()); // [cite: 44, 51]
        System.out.println("\nDistribuição das chaves (Clusterização):"); // [cite: 46, 52]
        System.out.println(map1.qtdeBuckets());

        // --- Relatório Tabela 2 ---
        System.out.println("\n==============================================");
        System.out.println("  Tabela Hash 2 (somaPesosVogaisMaisConsoantes)");
        System.out.println("==============================================");
        System.out.println("Tempo total de inserção: " + tempoInsercao2 + " ms"); // [cite: 45]
        System.out.println("Tempo total de busca (todos os nomes): " + tempoBusca2 + " ms"); // [cite: 45]
        System.out.println("Número total de colisões: " + map2.returnColisoes()); // [cite: 44, 51]
        System.out.println("\nDistribuição das chaves (Clusterização):"); // [cite: 46, 52]
        System.out.println(map2.qtdeBuckets());
    }
}