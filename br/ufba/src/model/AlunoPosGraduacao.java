package br.ufba.src.model;

import br.ufba.src.constantes.ConstantesEmprestimo;
import br.ufba.src.services.RegraEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.tempoEmprestimo = ConstantesEmprestimo.tempoEmprestimoPosGraduacao;
        this.limiteEmprestimos = ConstantesEmprestimo.limiteEmprestimoPosGraduacao;
        this.regraEmprestimo = new RegraEmprestimoAluno();
    }

}
