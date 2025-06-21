package br.ufba.src.model;

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

    public abstract int getPrazoEmprestimo();
    
    public abstract void realizarEmprestimo(Livro livro);

    public abstract void realizarDevolucao(Livro livro);

    public abstract void realizarReserva(Livro livro);

    public abstract void observarLivro(Livro livro);

    public String getCodigo() {
        return this.codigo;
    }

    public void consultarNotificacoes() {
    }

    public void consultarInformacoes() {
    }

}
