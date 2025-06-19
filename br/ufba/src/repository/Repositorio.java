package repository;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
import model.Usuario;

public class Repositorio {
    
    private List<Usuario> usuarios;
    private List<Livro> livros;
    
    private static Repositorio instancia;

    private Repositorio() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public static Repositorio getInstancia() {
        if(instancia == null){
            instancia = new Repositorio();
        }
        return instancia;
    }

    public Usuario buscarUsuarioPorCodigo(String codigo){
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivroPorCodigo(String codigo){
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null;
    }
}
