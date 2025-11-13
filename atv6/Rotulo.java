public class Rotulo {
    private String descricao;

    public Rotulo(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do rótulo não pode ser vazia");
        }
        this.descricao = descricao.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do rótulo não pode ser vazia");
        }
        this.descricao = descricao.trim();
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rotulo rotulo = (Rotulo) obj;
        return descricao.equalsIgnoreCase(rotulo.descricao);
    }

    @Override
    public int hashCode() {
        return descricao.toLowerCase().hashCode();
    }
}