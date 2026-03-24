import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[100];
        int totalAlunos = 0;
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE ALUNOS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por matrícula");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    if (totalAlunos < alunos.length) {
                        System.out.print("Nome: ");
                        scanner.nextLine(); // limpar buffer
                        String nome = scanner.nextLine();

                        System.out.print("Matrícula: ");
                        int matricula = scanner.nextInt();

                        System.out.print("Nota 1: ");
                        double nota1 = scanner.nextDouble();

                        System.out.print("Nota 2: ");
                        double nota2 = scanner.nextDouble();

                        alunos[totalAlunos] = new Aluno(nome, matricula, nota1, nota2);
                        totalAlunos++;

                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite atingido!");
                    }
                    break;

                case 2:
                    if (totalAlunos == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (int i = 0; i < totalAlunos; i++) {
                            System.out.println("\nNome: " + alunos[i].getNome());
                            System.out.println("Matrícula: " + alunos[i].getMatricula());
                            System.out.println("Média: " + alunos[i].calcularMedia());
                            System.out.println("Situação: " + alunos[i].getSituacao());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite a matrícula: ");
                    int busca = scanner.nextInt();
                    boolean encontrado = false;

                    for (int i = 0; i < totalAlunos; i++) {
                        if (alunos[i].getMatricula() == busca) {
                            System.out.println("\nAluno encontrado:");
                            System.out.println("Nome: " + alunos[i].getNome());
                            System.out.println("Média: " + alunos[i].calcularMedia());
                            System.out.println("Situação: " + alunos[i].getSituacao());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
