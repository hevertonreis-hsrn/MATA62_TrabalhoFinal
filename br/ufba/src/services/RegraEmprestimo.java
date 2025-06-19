package services;
import model.Livro;
import model.Usuario;

public interface RegraEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
}
