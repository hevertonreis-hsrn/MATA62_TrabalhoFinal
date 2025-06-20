package MATA62_TrabalhoFinal.br.ufba.src.repository;
import java.util.ArrayList;
import java.util.List;

import MATA62_TrabalhoFinal.br.ufba.src.model.Livro;
import MATA62_TrabalhoFinal.br.ufba.src.model.Usuario;

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

    public Usuario buscarUsuarioPorCodigo(int codigo){
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivroPorCodigo(int codigo){
        for (Livro livro : livros) {
            if (livro.getCodigo()  == codigo) {
                return livro;
            }
        }
        return null;
    }
}
