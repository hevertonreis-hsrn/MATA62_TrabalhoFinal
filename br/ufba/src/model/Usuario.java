package br.ufba.src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufba.src.services.RegraEmprestimo;
import br.ufba.src.services.ResultadoOperacao;

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

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public ResultadoOperacao realizarEmprestimo(Livro livro){

        ResultadoOperacao resultadoOperacao = regraEmprestimo.podeEmprestar(this, livro);
        
        if(!resultadoOperacao.isSucesso()){
            return resultadoOperacao;
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

        return new ResultadoOperacao(true, "Emprestimo realizado com sucesso!");
    }

    public ResultadoOperacao realizarDevolucao(Livro livro){
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.estaAberto() && emprestimo.getExemplar().getLivro().equals(livro)){
                emprestimo.efetuarDevolucao();
                return new ResultadoOperacao(true, "Devolucao realizada com sucesso!");
            }
        }

        return new ResultadoOperacao(false, "Nao foi possivel efetuar a devolucao. Nao existe emprestimos em aberto para este livro.");
    }

}
