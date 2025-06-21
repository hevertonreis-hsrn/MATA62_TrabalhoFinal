package br.ufba.src.model;
public class Exemplar {
    
    private String codigo;
    private Livro livro;
    private boolean disponivel;

    public Exemplar(String codigo, Livro livro, boolean disponivel) {
        this.codigo = codigo;
        this.livro = livro;
        this.disponivel = disponivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
