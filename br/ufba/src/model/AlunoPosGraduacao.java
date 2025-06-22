package br.ufba.src.model;

import br.ufba.src.services.RegraEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.regraEmprestimo = new RegraEmprestimoAluno();
    }

    @Override
    public int getTempoEmprestimo() {
        return 5;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

}
