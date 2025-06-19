package services;
import model.Livro;
import model.Usuario;

public class Regra1 implements RegraEmprestimo{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        return false;
    }
}
