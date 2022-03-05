import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desafio3 {
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Digite um texto para criptografar: ");
            String texto = entrada.readLine();

            System.out.println("Seu texto criptografado é: " + encriptar(texto));
        } catch (IOException e) {
            System.err.println("Problema identificado: " + e.getMessage());
        }
    }

    public static String encriptar(String texto) {
        String textoLimpo = texto.replaceAll("\\s+","");
        int tamanho = textoLimpo.length();

        int raiz = (int)Math.ceil(Math.sqrt(tamanho));

        char[][] grid = new char[raiz][raiz];

        int posicao = 0;
        for (int i = 0; i < textoLimpo.length(); i += raiz) {
            for (int j = 0; j < raiz && i + j < textoLimpo.length(); j++) {
                grid[posicao][j] = textoLimpo.charAt(i + j);
            }
            posicao++;
        }

        StringBuilder encriptada = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char letra = grid[j][i];
                if (isAsciiPrintable(letra)) {
                    encriptada.append(letra);
                }
            }
            encriptada.append(" ");
        }
        return encriptada.toString();
    }

    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }
}
