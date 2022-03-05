import java.util.Arrays;
import java.util.Scanner;

public class Desafio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Quantos numeros vamos analizar? ");

        int qtdNumeros = entrada.nextInt();
        if (qtdNumeros % 2 == 0 ) { // resto da divisão
            System.err.print("Quantidade invalida, precisa ser uma quantidade impar.");
            System.exit(1);
        }

        int[] numeros = new int[qtdNumeros];
        System.out.println("Entre com os números (ex.: 9 5 4 28 9): ");
        for(int i=0; i<qtdNumeros; i++) {
            numeros[i] = entrada.nextInt();
        }

        Arrays.sort(numeros);

        int mediana = numeros[(numeros.length - 1) / 2];
        System.out.println("A mediana encontrada foi: " + mediana);
    }
}
