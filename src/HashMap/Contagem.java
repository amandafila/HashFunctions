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
}