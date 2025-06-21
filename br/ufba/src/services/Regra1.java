package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public class Regra1 implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        return false;
    }
}
