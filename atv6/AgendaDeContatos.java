import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaDeContatos {
    private final List<Contato> contatos;

    public AgendaDeContatos() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (contato == null) {
            throw new IllegalArgumentException("Contato não pode ser nulo");
        }
        
        
        if (buscarContato(contato.getNome()) != null) {
            System.out.println("Já existe um contato com o nome '" + contato.getNome() + "'");
            return;
        }
        
        contatos.add(contato);
        System.out.println("Contato '" + contato.getNome() + "' adicionado com sucesso!");
    }

    public boolean removerContato(String nome) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato '" + nome + "' removido com sucesso!");
            return true;
        } else {
            System.out.println("Contato '" + nome + "' não encontrado!");
            return false;
        }
    }

    public Contato buscarContato(String nome) {
        return contatos.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Contato> buscarContatosPorParteDoNome(String parteNome) {
        return contatos.stream()
                .filter(c -> c.getNome().toLowerCase().contains(parteNome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contato> listarContatos() {
        return new ArrayList<>(contatos);
    }

    public void exibirTodosContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado na agenda.");
        } else {
            System.out.println("\n=== LISTA DE CONTATOS (" + contatos.size() + ") ===");
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("Contato #" + (i + 1));
                System.out.println(contatos.get(i));
                if (i < contatos.size() - 1) {
                    System.out.println("-------------------");
                }
            }
        }
    }

    public int getQuantidadeContatos() {
        return contatos.size();
    }

    public boolean estaVazia() {
        return contatos.isEmpty();
    }
}