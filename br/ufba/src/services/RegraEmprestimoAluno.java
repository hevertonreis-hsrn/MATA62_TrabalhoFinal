package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoAluno implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        
        if(!livro.temExemplarDisponivel()){
            return false;
        }

        if(usuario.temDevolucaoAtrasada()){
            return false;
        }

        if (usuario.qtdEmprestimosEmAberto() == usuario.getLimiteEmprestimos()) {
            return false;
        }

        int qtdReservas = livro.qtdReservas();
        int qtdExemplaresDisponiveis = livro.qtdExemplaresDisponiveis();
        boolean possuiReserva = livro.reservaPertenceAoUsuario(usuario);

        if (qtdReservas >= qtdExemplaresDisponiveis && !possuiReserva) {
            return false;
        }

        if (usuario.possuiEmprestimoLivro(livro)) {
            return false;
        }

        return true;
    }
}
