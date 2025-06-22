package br.ufba.src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufba.src.services.RegraEmprestimo;

public abstract class Usuario {
    
    protected String codigo;
    protected String nome;
    protected List<Emprestimo> emprestimos;
    protected RegraEmprestimo regraEmprestimo;

    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public abstract int getTempoEmprestimo();

    public abstract int getLimiteEmprestimos();

    public void realizarDevolucao(Livro livro){

    }

    public void realizarReserva(Livro livro){

    }

    public String getCodigo() {
        return this.codigo;
    }

    public void consultarNotificacoes() {
    }

    public void consultarInformacoes() {
    }

    public boolean temDevolucaoAtrasada() {
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.estaAtrasado()){
                return true;
            }
        }
        return false;
    }

    public int qtdEmprestimosEmAberto() {
        int qtd = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.estaAberto()){
                qtd++;
            }
        }
        return qtd;
    }

    public boolean possuiEmprestimoLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAberto() && emprestimo.getExemplar().getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    private void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void realizarEmprestimo(Livro livro){
        if(!regraEmprestimo.podeEmprestar(this, livro)){
            return;
        }

        Exemplar exemplar = livro.getExemplarDisponivel();

        LocalDate dataEmprestimo = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(
            this, 
            exemplar, 
            dataEmprestimo, 
            dataEmprestimo.plusDays(getTempoEmprestimo()));

        this.adicionarEmprestimo(emprestimo);
        exemplar.definirComoEmprestado();
        livro.removerReservaUsuario(this);
    }


}
