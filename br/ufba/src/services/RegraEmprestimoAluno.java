package br.ufba.src.services;

import br.ufba.src.constantes.Mensagem;
import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoAluno implements RegraEmprestimo{
    @Override
    public ResultadoOperacao podeEmprestar(Usuario usuario, Livro livro) {
        
        if(!livro.temExemplarDisponivel()){
            return new ResultadoOperacao(false, Mensagem.semExemplares);
        }

        if(usuario.temDevolucaoAtrasada()){
            return new ResultadoOperacao(false, Mensagem.devolucoesEmAtraso);
        }

        if (usuario.qtdEmprestimosEmAberto() == usuario.getLimiteEmprestimos()) {
            return new ResultadoOperacao(false, Mensagem.limiteAtingido);
        }

        int qtdReservas = livro.qtdReservas();
        int qtdExemplaresDisponiveis = livro.qtdExemplaresDisponiveis();
        boolean possuiReserva = livro.reservaPertenceAoUsuario(usuario);

        if (qtdReservas >= qtdExemplaresDisponiveis && !possuiReserva) {
            return new ResultadoOperacao(false, Mensagem.livroReservado);
        }

        if (usuario.possuiEmprestimoLivro(livro)) {
            return new ResultadoOperacao(false, Mensagem.emprestimoEmAberto);
        }

        return new ResultadoOperacao(true, Mensagem.emprestimo);
    }
}
