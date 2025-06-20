package MATA62_TrabalhoFinal.br.ufba.src.services;

import MATA62_TrabalhoFinal.br.ufba.src.model.Livro;
import MATA62_TrabalhoFinal.br.ufba.src.model.Usuario;

public class Regra2 implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        return false;
    }
}
