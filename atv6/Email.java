public class Email {
    private String endereco;
    private Rotulo rotulo;

    public Email(String endereco, Rotulo rotulo) {
        this.endereco = validateEndereco(endereco);
        this.rotulo = rotulo;
    }

    public String getEndereco() {
        return endereco;
    }

    private static String validateEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        if (!endereco.contains("@")) {
            throw new IllegalArgumentException("Email deve conter @");
        }
        return endereco.trim();
    }

    public void setEndereco(String endereco) {
        this.endereco = validateEndereco(endereco);
    }

    public Rotulo getRotulo() {
        return rotulo;
    }

    public void setRotulo(Rotulo rotulo) {
        this.rotulo = rotulo;
    }

    @Override
    public String toString() {
        return rotulo.getDescricao() + ": " + endereco;
    }
}