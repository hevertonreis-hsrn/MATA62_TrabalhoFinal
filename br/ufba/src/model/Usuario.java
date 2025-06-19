package model;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    
    protected String codigo;
    protected String nome;
    protected List<Emprestimo> emprestimos;

    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public abstract void realizarEmprestimo(Livro livro);
}
