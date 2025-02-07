import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SeparacaoSexos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> grupos = new HashMap<>();

        System.out.println("Digite os nomes e sexos (nome-sexo), separados por vírgula:");
        String entrada = scanner.nextLine();

        // Divide a string de entrada em pares nome-sexo
        String[] pessoas = entrada.split(",");

        for (String pessoa : pessoas) {
            String[] dados = pessoa.split("-");
            String nome = dados[0].trim().toLowerCase();
            String sexo = dados[1].trim().toLowerCase();

            // Valida o sexo
            if (!sexo.equals("f") && !sexo.equals("m")) {
                System.out.println("Sexo inválido para " + nome + ". Use 'F' para feminino ou 'M' para  masculino.");
                continue;
            }

            // Formata o nome com a primeira letra de cada parte em maiúscula
            String[] partes = nome.split("\\s+");
            StringBuilder nomeFormatado = new StringBuilder();
            for (String parte : partes) {
                if (!parte.isEmpty()) {
                    nomeFormatado.append(Character.toUpperCase(parte.charAt(0))).append(parte.substring(1)).append(" ");
                }
            }
            nome = nomeFormatado.toString().trim();

            // Adiciona o nome ao grupo correto
            if (!grupos.containsKey(sexo)) {
                grupos.put(sexo, new ArrayList<>());
            }
            grupos.get(sexo).add(nome);
        }

        // Imprime os grupos
        System.out.println("\nGrupos:");
        for (Map.Entry<String, List<String>> entry : grupos.entrySet()) {
            String sexoFormatado;
            if (entry.getKey().equals("f")) {
                sexoFormatado = "Feminino";
            } else {
                sexoFormatado = "Masculino";
            }
            System.out.println(sexoFormatado + ": " + entry.getValue());
        }

        scanner.close();
    }
}