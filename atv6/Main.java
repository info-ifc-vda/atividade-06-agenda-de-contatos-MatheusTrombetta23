import java.util.List;
import java.util.Scanner;

public class Main {
    private static final AgendaDeContatos agenda = new AgendaDeContatos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== AGENDA DE CONTATOS ===");
        
        while (true) {
            exibirMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    buscarContatoExato();
                    break;
                case 4:
                    buscarContatosPorParte();
                    break;
                case 5:
                    agenda.exibirTodosContatos();
                    break;
                case 6:
                    System.out.println("Total de contatos: " + agenda.getQuantidadeContatos());
                    break;
                case 0:
                    System.out.println("Saindo da agenda. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Buscar Contato (Nome Exato)");
        System.out.println("4 - Buscar Contatos (Por Parte do Nome)");
        System.out.println("5 - Listar Todos os Contatos");
        System.out.println("6 - Quantidade de Contatos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void adicionarContato() {
        try {
            System.out.print("Digite o nome do contato: ");
            String nome = scanner.nextLine().trim();
            
            if (nome.isEmpty()) {
                System.out.println("Nome não pode ser vazio!");
                return;
            }
            
            Contato contato = new Contato(nome);
            
            
            System.out.println("Deseja adicionar telefones? (s/n)");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                adicionarTelefones(contato);
            }
            
            
            System.out.println("Deseja adicionar emails? (s/n)");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                adicionarEmails(contato);
            }
            
            agenda.adicionarContato(contato);
            
        } catch (Exception e) {
            System.out.println("Erro ao adicionar contato: " + e.getMessage());
        }
    }

    private static void adicionarTelefones(Contato contato) {
        while (true) {
            try {
                System.out.print("Digite o número do telefone: ");
                String numero = scanner.nextLine().trim();
                
                System.out.print("Digite o rótulo (ex: Celular, Casa, Trabalho): ");
                String rotuloDesc = scanner.nextLine().trim();
                
                Rotulo rotulo = new Rotulo(rotuloDesc);
                contato.adicionarTelefone(numero, rotulo);
                
                System.out.println("Telefone adicionado com sucesso!");
                
            } catch (Exception e) {
                System.out.println("Erro ao adicionar telefone: " + e.getMessage());
            }
            
            System.out.println("Deseja adicionar outro telefone? (s/n)");
            if (!scanner.nextLine().equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    private static void adicionarEmails(Contato contato) {
        while (true) {
            try {
                System.out.print("Digite o endereço de email: ");
                String email = scanner.nextLine().trim();
                
                System.out.print("Digite o rótulo (ex: Pessoal, Trabalho): ");
                String rotuloDesc = scanner.nextLine().trim();
                
                Rotulo rotulo = new Rotulo(rotuloDesc);
                contato.adicionarEmail(email, rotulo);
                
                System.out.println("Email adicionado com sucesso!");
                
            } catch (Exception e) {
                System.out.println("Erro ao adicionar email: " + e.getMessage());
            }
            
            System.out.println("Deseja adicionar outro email? (s/n)");
            if (!scanner.nextLine().equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    private static void removerContato() {
        System.out.print("Digite o nome do contato a ser removido: ");
        String nome = scanner.nextLine().trim();
        agenda.removerContato(nome);
    }

    private static void buscarContatoExato() {
        System.out.print("Digite o nome exato do contato: ");
        String nome = scanner.nextLine().trim();
        
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            System.out.println("\n=== CONTATO ENCONTRADO ===");
            System.out.println(contato);
        } else {
            System.out.println("Contato '" + nome + "' não encontrado!");
        }
    }

    private static void buscarContatosPorParte() {
        System.out.print("Digite parte do nome para buscar: ");
        String parteNome = scanner.nextLine().trim();
        
        List<Contato> contatosEncontrados = agenda.buscarContatosPorParteDoNome(parteNome);
        
        if (contatosEncontrados.isEmpty()) {
            System.out.println("Nenhum contato encontrado com '" + parteNome + "' no nome.");
        } else {
            System.out.println("\n=== CONTATOS ENCONTRADOS (" + contatosEncontrados.size() + ") ===");
            for (int i = 0; i < contatosEncontrados.size(); i++) {
                System.out.println("Contato #" + (i + 1));
                System.out.println(contatosEncontrados.get(i));
                if (i < contatosEncontrados.size() - 1) {
                    System.out.println("-------------------");
                }
            }
        }
    }
}