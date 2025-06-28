package br.ufba.src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufba.src.constantes.Mensagem;
import br.ufba.src.services.RegraEmprestimo;
import br.ufba.src.services.ResultadoOperacao;

public abstract class Usuario {
    
    protected String codigo;
    protected String nome;
    protected List<Emprestimo> emprestimos;
    protected List<Reserva> reservas;
    protected RegraEmprestimo regraEmprestimo;
    protected int tempoEmprestimo;
    protected int limiteEmprestimos;

    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>(); 
    }

    public int getTempoEmprestimo(){
        return tempoEmprestimo;
    }

    public int getLimiteEmprestimos(){
        return limiteEmprestimos;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int consultarNotificacoes(){return 0;}

    public String consultarInformacoes() {
        String strRetorno = retornaListaEmprestimos();
        strRetorno += retornaListaReservas();

        return strRetorno;
    }

    public String retornaListaEmprestimos() {
        String strRetorno = "| Empréstimos |\n";
        for (Emprestimo emprestimo : emprestimos) {
            strRetorno += emprestimo.getTituloLivro() +
                    " | Data de empréstimo: " + emprestimo.getDataEmprestimo() +
                    " | Status: ";
            if (emprestimo.estaAberto()) {
                strRetorno += "Em curso" +
                        " | Data prevista para devolução: " + emprestimo.getDataDevolucaoEstimada();
            } else {
                strRetorno += "Finalizado" +
                        " | Data de devolução: " + emprestimo.getDataDevolucao();
            }
            strRetorno += "\n";
        }
        return strRetorno;
    }

    public String retornaListaReservas() {
            String strRetorno = "| Reservas |\n";
            for (Reserva reserva : reservas) {
                strRetorno += reserva.getTituloLivro() +
                              " | Data de solicitação da reserva: " + reserva.getDataReserva() +"\n";
            }
            return strRetorno;
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

    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
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
        exemplar.definirComoEmprestado(emprestimo);
        livro.removerReservaUsuario(this);

        return resultadoOperacao;
    }

    public ResultadoOperacao realizarDevolucao(Livro livro){
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.estaAberto() && emprestimo.getExemplar().getLivro().equals(livro)){
                emprestimo.efetuarDevolucao();
                return new ResultadoOperacao(true, Mensagem.devolucao);
            }
        }

        return new ResultadoOperacao(false, Mensagem.semDevolucao);
    }

    
    public ResultadoOperacao realizarReserva(Livro livro){
        if (livro.reservaPertenceAoUsuario(this)) {
            return new ResultadoOperacao(false, Mensagem.semReserva);
        }

        Reserva reserva = new Reserva(this, livro, LocalDate.now());
        this.adicionarReserva(reserva);
        livro.adicionarReserva(reserva);

        return new ResultadoOperacao(true, Mensagem.reserva);
    }

    public String toString(){
        return this.nome;
    }

}
