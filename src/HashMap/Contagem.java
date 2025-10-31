package HashMap;

public class Contagem {

    public static int produtoVogaisConsoantes(String texto) {
        texto = texto == null ? "" : texto.toLowerCase();
        int h = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < 'a' || c > 'z') continue;

            int peso = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 3 : 7;

            int valorChar = (c - 'a' + 1);

            h = h * 31 + peso * valorChar;
        }

        h ^= (h >>> 16);

        return h & 0x7fffffff;
    }


    public static int somaPesosVogaisMaisConsoantes(String texto) {
        texto = texto == null ? "" : texto.toLowerCase();
        int h = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < 'a' || c > 'z') continue;

            int peso;
            switch (c) {
                case 'a': peso = 2; break;
                case 'e': peso = 3; break;
                case 'i': peso = 5; break;
                case 'o': peso = 11; break;
                case 'u': peso = 7; break;
                default:  peso = 1;  break;
            }

            int contrib = peso * (i + 1) + (c - 'a');

            h = h * 131 ^ contrib;
        }

        h ^= (h >>> 13);

        return h & 0x7fffffff;
    }


}