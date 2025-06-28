package br.ufba.src.model;
public class Exemplar {
    
    private String codigo;
    private Livro livro;
    private boolean disponivel;
    private Emprestimo emprestimo;

    public Exemplar(String codigo, Livro livro, boolean disponivel) {
        this.codigo = codigo;
        this.livro = livro;
        this.disponivel = disponivel;
    }

    public String getTituloLivro(){
        return livro.getTitulo();
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

    public boolean estaDisponivel() {
        return disponivel;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void definirComoEmprestado(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.disponivel = false;
    }

    public void definirComoDisponivel() {
        this.emprestimo = null;
        this.disponivel = true;
    }

}
