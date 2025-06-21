package br.ufba.src.services;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;

public interface RegraEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
}
