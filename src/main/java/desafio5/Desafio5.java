package desafio5;

import java.util.Scanner;

public class Desafio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe uma string para inverter: ");
        String input = scanner.nextLine();

        scanner.close();

        String inverted = inverterString(input);

        System.out.println("String invertida: " + inverted);
    }

    // Função para inverter uma string
    public static String inverterString(String str) {
        char[] caracteres = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            caracteres[i] = str.charAt(str.length() - 1 - i);
        }

        return new String(caracteres);
    }
}

