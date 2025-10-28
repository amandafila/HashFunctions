package HashMap;

public class Contagem {

    public static int produtoVogaisConsoantes(String texto) {
        int vogais = 0;
        int consoantes = 0;
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vogais++;
                } else {
                    consoantes++;
                }
            }
        }

        return (vogais + 7 * consoantes * 12) % 32;
    }


    public static int somaPesosVogaisMaisConsoantes(String texto) {
        int somaVogais = 0;
        int consoantes = 0;
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'a' && c <= 'z') {
                switch (c) {
                    case 'a':
                        somaVogais += 2;
                        break;
                    case 'e':
                        somaVogais += 3;
                        break;
                    case 'i':
                        somaVogais += 5;
                        break;
                    case 'o':
                        somaVogais += 11;
                        break;
                    case 'u':
                        somaVogais += 7;
                        break;
                    default:
                        consoantes++;
                        break;
                }
            }
        }

        return (somaVogais + consoantes) % 32;
    }








}