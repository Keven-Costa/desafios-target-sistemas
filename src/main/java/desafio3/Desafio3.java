package desafio3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Desafio3 {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new File("src/main/java/desafio3/dados.json"));

            List<Double> faturamentos = new ArrayList<>();
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            for (JsonNode dia : root) {
                double valor = dia.get("valor").asDouble();
                if (valor > 0) {
                    faturamentos.add(valor);
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double menorFaturamento = faturamentos.stream().min(Double::compareTo).orElse(0.0);
            double maiorFaturamento = faturamentos.stream().max(Double::compareTo).orElse(0.0);

            double mediaFaturamento = somaFaturamento / diasComFaturamento;

            long diasAcimaMedia = faturamentos.stream().filter(fat -> fat > mediaFaturamento).count();

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
