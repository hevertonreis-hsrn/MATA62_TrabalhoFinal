package br.ufba.src.services;

import br.ufba.src.constantes.Mensagem;
import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoProfessor implements RegraEmprestimo{
    @Override
    public ResultadoOperacao podeEmprestar(Usuario usuario, Livro livro) {
        if(!livro.temExemplarDisponivel()){
            return new ResultadoOperacao(false, Mensagem.semExemplares);
        }

        if(usuario.temDevolucaoAtrasada()){
            return new ResultadoOperacao(false, Mensagem.devolucoesEmAtraso);
        }

        return new ResultadoOperacao(true, Mensagem.emprestimo);
    }
}
