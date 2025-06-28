package br.ufba.src.model;

import br.ufba.src.constantes.ConstantesEmprestimo;
import br.ufba.src.services.Observador;
import br.ufba.src.services.RegraEmprestimoProfessor;
import br.ufba.src.services.Sujeito;

public class Professor extends Usuario implements Observador {

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        this.tempoEmprestimo = ConstantesEmprestimo.tempoEmprestimoProfessor;
        this.limiteEmprestimos = ConstantesEmprestimo.limiteEmprestimoProfessor;
        this.regraEmprestimo = new RegraEmprestimoProfessor();
    }

    private int numeroNotificacoes = 0;
    @Override
    public void notificar(Sujeito sujeito) {
        numeroNotificacoes++;
    }

    public int consultarNotificacoes(){
        return numeroNotificacoes;
    }

    public void observarLivro(Livro livro){
        livro.adicionarObservador(this);
    }

}
