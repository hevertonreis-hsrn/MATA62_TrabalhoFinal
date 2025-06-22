package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class RegraEmprestimoProfessor implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if(!livro.temExemplarDisponivel()){
            return false;
        }

        if(usuario.temDevolucaoAtrasada()){
            return false;
        }

        return true;
    }
}
