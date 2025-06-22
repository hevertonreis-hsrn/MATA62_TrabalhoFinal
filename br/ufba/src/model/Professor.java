package br.ufba.src.model;

import br.ufba.src.services.Observador;
import br.ufba.src.services.RegraEmprestimoProfessor;
import br.ufba.src.services.Sujeito;

public class Professor extends Usuario implements Observador {

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        this.regraEmprestimo = new RegraEmprestimoProfessor();
    }

    @Override
    public void notificar(Sujeito sujeito) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
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
