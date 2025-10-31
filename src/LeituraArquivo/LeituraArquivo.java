package LeituraArquivo;
import HashMap.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

    public static long carregarArquivo(String caminho, HashMap mapa) {
        long inicio = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] partes = linha.split("\\s+");
                    String key = partes[0];
                    mapa.put(key);
                }
            }

            long fim = System.currentTimeMillis();
            long duracao = fim - inicio;

            System.out.println("Arquivo carregado no mapa (" + mapa.getClass().getSimpleName() + ") com sucesso!");

            return duracao;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return -1;
        }
    }

    public static long testarBusca(String caminho, HashMap mapa) {
        long inicio = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    mapa.get(linha);
                }
            }

            long fim = System.currentTimeMillis();
            return fim - inicio;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo para busca: " + e.getMessage());
            return -1;
        }
    }
}