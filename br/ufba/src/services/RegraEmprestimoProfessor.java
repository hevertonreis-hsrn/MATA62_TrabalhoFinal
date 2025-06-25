package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoProfessor implements RegraEmprestimo{
    @Override
    public ResultadoOperacao podeEmprestar(Usuario usuario, Livro livro) {
        if(!livro.temExemplarDisponivel()){
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! Nao existem exemplares disponiveis na biblioteca.");
        }

        if(usuario.temDevolucaoAtrasada()){
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! Existem devolucoes em atraso para este usuario.");
        }

        return new ResultadoOperacao(true, "Emprestimo admitido.");
    }
}
