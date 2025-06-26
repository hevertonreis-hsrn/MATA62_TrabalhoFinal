package br.ufba.src.model;

import br.ufba.src.services.Observador;
import br.ufba.src.services.RegraEmprestimoProfessor;
import br.ufba.src.services.Sujeito;

public class Professor extends Usuario implements Observador {

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        this.regraEmprestimo = new RegraEmprestimoProfessor();
    }

    private int contagemNotificacoes = 0;
    @Override
    public void notificar(Sujeito sujeito) {
        contagemNotificacoes++;
    }

    public int getContagemNotificacoes(){
        return contagemNotificacoes;
    }

    public void observarLivro(Livro livro){
        livro.adicionarObservador(this);
    }

    @Override
    public int getTempoEmprestimo() {
        return 8;
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE;
    }

}
