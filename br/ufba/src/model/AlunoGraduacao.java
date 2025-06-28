package br.ufba.src.model;

import br.ufba.src.constantes.ConstantesEmprestimo;
import br.ufba.src.services.RegraEmprestimoAluno;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.tempoEmprestimo = ConstantesEmprestimo.tempoEmprestimoGraduacao;
        this.limiteEmprestimos = ConstantesEmprestimo.limiteEmprestimoGraduacao;
        this.regraEmprestimo = new RegraEmprestimoAluno();
    }

}
