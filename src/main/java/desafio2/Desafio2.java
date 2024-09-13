package desafio2;

import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número Inteiro: ");

        if (scanner.hasNextInt()){
            int numero = scanner.nextInt();

            if (pertenceFibonacci(numero)) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
            }

        } else {
            System.out.println("Erro: O valor informado não é um número inteiro válido. Por favor, insira um número inteiro.");
        }

        scanner.close();
    }

    public static boolean pertenceFibonacci(int numero) {
        int a = 0, b = 1, soma;

        if (numero == 0 || numero == 1) {
            return true;
        }

        while (b < numero) {
            soma = a + b;
            a = b;
            b = soma;
        }

        return b == numero;
    }
}
