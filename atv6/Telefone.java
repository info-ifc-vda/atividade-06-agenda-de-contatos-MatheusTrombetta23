public class Telefone {
    private String numero;
    private Rotulo rotulo;

    public Telefone(String numero, Rotulo rotulo) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser vazio");
        }
        this.numero = numero.trim();
        this.rotulo = rotulo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser vazio");
        }
        this.numero = numero.trim();
    }

    public Rotulo getRotulo() {
        return rotulo;
    }

    public void setRotulo(Rotulo rotulo) {
        this.rotulo = rotulo;
    }

    @Override
    public String toString() {
        return rotulo.getDescricao() + ": " + numero;
    }
}