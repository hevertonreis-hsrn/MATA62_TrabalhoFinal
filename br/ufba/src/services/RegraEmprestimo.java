package MATA62_TrabalhoFinal.br.ufba.src.services;

import MATA62_TrabalhoFinal.br.ufba.src.model.Livro;
import MATA62_TrabalhoFinal.br.ufba.src.model.Usuario;

public interface RegraEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
}
