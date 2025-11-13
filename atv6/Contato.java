import java.util.ArrayList;
import java.util.List;

public class Contato {
    private String nome;
    private final List<Telefone> telefones;
    private final List<Email> emails;

    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public void adicionarTelefone(String numero, Rotulo rotulo) {
        Telefone telefone = new Telefone(numero, rotulo);
        telefones.add(telefone);
    }

    public void adicionarEmail(String endereco, Rotulo rotulo) {
        Email email = new Email(endereco, rotulo);
        emails.add(email);
    }

    public boolean removerTelefone(String numero) {
        return telefones.removeIf(t -> t.getNumero().equals(numero));
    }

    public boolean removerEmail(String endereco) {
        return emails.removeIf(e -> e.getEndereco().equals(endereco));
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefones() {
        return new ArrayList<>(telefones);
    }

    public List<Email> getEmails() {
        return new ArrayList<>(emails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        
        if (!telefones.isEmpty()) {
            sb.append("Telefones:\n");
            for (Telefone telefone : telefones) {
                sb.append("  - ").append(telefone).append("\n");
            }
        }
        
        if (!emails.isEmpty()) {
            sb.append("Emails:\n");
            for (Email email : emails) {
                sb.append("  - ").append(email).append("\n");
            }
        }
        
        return sb.toString();
    }
}