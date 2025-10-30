package LeituraArquivo;
import HashMap.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

    public static void carregarArquivo(String caminho, HashMapFunction1 mapa) {
        long inicio = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] partes = linha.split("\\s+");

                    String key = partes[0];
                    String value = (partes.length > 1) ? partes[1] : "";

                    mapa.put(key);
                }
            }

            long fim = System.currentTimeMillis();
            long duracao = fim - inicio;

            System.out.println("Arquivo carregado com sucesso!");
            System.out.println("Tempo total de inserção: " + duracao + " ms");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}