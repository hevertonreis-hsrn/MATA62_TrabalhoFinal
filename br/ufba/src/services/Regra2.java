package services;
import model.Livro;
import model.Usuario;

public class Regra2 implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        return false;
    }
}
