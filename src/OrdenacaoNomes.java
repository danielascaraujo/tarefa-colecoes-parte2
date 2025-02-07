import java.util.Arrays;
import java.util.Scanner;

public class OrdenacaoNomes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes separados por vírgula:");
        String nomesInput = scanner.nextLine();

        // Divide a string de entrada em um array de nomes
        String[] nomes = nomesInput.split(",");

        // Remove espaços em branco extras e converte para minúsculas
        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i].trim().toLowerCase();
            if (!nome.isEmpty()) {
                String[] partes = nome.split("\\s+"); // Divide em partes por espaços
                StringBuilder nomeFormatado = new StringBuilder();
                for (String parte : partes) {
                    if (!parte.isEmpty()) {
                        nomeFormatado.append(Character.toUpperCase(parte.charAt(0))).append(parte.substring(1)).append(" ");
                    }
                }
                nomes[i] = nomeFormatado.toString().trim();
            }
        }

        // Ordena o array de nomes em ordem alfabética
        Arrays.sort(nomes);

        // Imprime os nomes ordenados
        System.out.println("\nNomes:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
}