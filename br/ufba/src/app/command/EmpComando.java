package br.ufba.src.app.command;

import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;

public class EmpComando implements Comando {
    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));
        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(2));

        usuario.realizarEmprestimo(livro);

        return true;
    }
}
