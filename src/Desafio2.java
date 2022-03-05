import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Desafio2 {
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Entre com os números (ex.: 9 5 4 28 9): ");
            String input = entrada.readLine();

            String[] valores = input.trim().split("\\s+");

            int[] numeros = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                numeros[i] = Integer.parseInt(valores[i]);
            }

            System.out.println("Qual valor de diferença deve ser encontrada? ");
            int differ = Integer.parseInt(entrada.readLine());

            Arrays.sort(numeros);

            List<String> arr = new ArrayList<>();
            for (int atual = 0; atual < numeros.length; atual++) {
                int valor = numeros[atual] + differ;
                for (int proximo = atual + 1; proximo < numeros.length; proximo++) {
                    if (numeros[proximo] == valor) {
                        arr.add("[" + numeros[atual] + ","+ numeros[proximo] + "]");
                    }
                }
            }

            System.out.print("Existem " + arr.size() + " pares de inteiros no vetor com a diferença de " + differ + ": ");
            System.out.println(arr.toString());
        } catch (IOException e) {
            System.err.println("Problema identificado: " + e.getMessage());
        }
    }
}
