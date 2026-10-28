import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Estudante> estudantes = new ArrayList<>();

    public static void main(String[] args) {
        menu();

    }
    public static void cadastrar() {
        System.out.print("Primeiro nome: ");
        String primeiroNome = sc.nextLine();

        System.out.print("Segundo nome: ");
        String segundoNome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Sexo: ");
        String sexo = sc.nextLine();

        System.out.print("Curso: ");
        String curso = sc.nextLine();

        System.out.print("Turno: ");
        String turno = sc.nextLine();

        Estudante estudante = new Estudante(primeiroNome, segundoNome, idade, sexo, curso, turno);
        estudantes.add(estudante);

        System.out.println("Estudante cadastrado com sucesso!");
        System.out.println();
    }

    public static void listar() {
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado!");
            return;
        }
        for (Estudante estudante : estudantes) {
            System.out.println(estudante.getNome() + " - " + estudante.getIdade() + " anos - " + estudante.getSexo() + " - " +
                    estudante.getCurso() + " - " + estudante.getTurno());
            System.out.println();
        }
    }

    public static void editar() {
        System.out.println("Qual estudante que deseja editar?");
        for (int i = 0; i < estudantes.size(); i++) {
            System.out.println(i + 1 + " - " + estudantes.get(i).getNome());
        }

        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice < 0 || indice >= estudantes.size()) {
            System.out.println("Digite um número valido!");
            return;
        }

        Estudante estudante = estudantes.get(indice);

        System.out.println("O que deseja editar?");
        System.out.println("1 - Primeiri Nome");
        System.out.println("2 - Segundo Nome");
        System.out.println("3 - Idade");
        System.out.println("4 - Sexo");
        System.out.println("5 - Curso");
        System.out.println("6 - Turno");

        int campo = sc.nextInt();
        sc.nextLine();

        if (campo == 1) {
            System.out.print("Novo primeiro nome: ");
            estudante.setPrimeiroNome(sc.nextLine());
        }
        else if (campo == 2) {
            System.out.println("Novo segundo nome: ");
            estudante.setSobrenome(sc.nextLine());
        }
        else if (campo == 3) {
            System.out.println("Nova Idade: ");
            estudante.setIdade(sc.nextInt());
            sc.nextLine();
        }
        else if (campo == 4) {
            System.out.println("Novo Sexo: ");
            estudante.setSexo(sc.nextLine());
        }
        else if (campo == 5) {
            System.out.println("Novo Curso: ");
            estudante.setCurso(sc.nextLine());
        }
        else if (campo == 6) {
            System.out.println("Novo Turno: ");
            estudante.setTurno(sc.nextLine());
        }
        else {
            System.out.println("Opção inválida!");
            return;
        }
        System.out.println("Estudante atualizado com sucesso!");
        System.out.println("");
    }

    public static void remover() {
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado!");
            return;
        }

        System.out.println("Qual estudante que deseja remover?");
        for (int i = 0; i < estudantes.size(); i++) {
            System.out.println(i + 1 + " - " + estudantes.get(i).getNome());
        }

        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice < 0 || indice >= estudantes.size()) {
            System.out.println("Digite um valor válido! ");
            return;
        }

        Estudante removido = estudantes.remove(indice);
        System.out.println(removido.getNome() + " removido com sucesso!");
    }
    public static void menu() {
        int opcao;

        do {
            System.out.println("==== Menu do Estudante ====");
            System.out.println();
            System.out.println("O que deseja fazer? ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    remover();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
        while (opcao != 0);
    }
}
