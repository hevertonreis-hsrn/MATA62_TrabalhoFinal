package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoAluno implements RegraEmprestimo{
    @Override
    public ResultadoOperacao podeEmprestar(Usuario usuario, Livro livro) {
        
        if(!livro.temExemplarDisponivel()){
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! Nao existem exemplares disponiveis na biblioteca.");
        }

        if(usuario.temDevolucaoAtrasada()){
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! Existem devolucoes em atraso para este usuario.");
        }

        if (usuario.qtdEmprestimosEmAberto() == usuario.getLimiteEmprestimos()) {
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! Limite atingido.");
        }

        int qtdReservas = livro.qtdReservas();
        int qtdExemplaresDisponiveis = livro.qtdExemplaresDisponiveis();
        boolean possuiReserva = livro.reservaPertenceAoUsuario(usuario);

        if (qtdReservas >= qtdExemplaresDisponiveis && !possuiReserva) {
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! O livro esta reservado para outros alunos.");
        }

        if (usuario.possuiEmprestimoLivro(livro)) {
            return new ResultadoOperacao(false, "Nao eh possivel fazer um novo emprestimo! O usuario possui um emprestimo em aberto deste livro.");
        }

        return new ResultadoOperacao(true, "Emprestimo admitido.");
    }
}
