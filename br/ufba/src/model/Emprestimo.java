package br.ufba.src.model;

import java.time.LocalDate;

public class Emprestimo {
    
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoEstimada;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Exemplar exemplar, LocalDate dataEmprestimo, LocalDate dataDevolucaoEstimada) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoEstimada = dataDevolucaoEstimada;
    }

    public String getTituloLivro(){
        return exemplar.getTituloLivro();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoEstimada() {
        return dataDevolucaoEstimada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean estaAtrasado() {
        return LocalDate.now().isAfter(dataDevolucaoEstimada);
    }

    public boolean estaAberto() {
        return dataDevolucao == null;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void efetuarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        this.exemplar.definirComoDisponivel();
    }
}
