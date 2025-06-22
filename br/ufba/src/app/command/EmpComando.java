package br.ufba.src.app.command;

import br.ufba.src.app.Console;
import br.ufba.src.model.Livro;
import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;
import br.ufba.src.services.ResultadoOperacao;

public class EmpComando implements Comando {

    private Console console;

    public EmpComando(Console console) {
        this.console = console;
    }

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));
        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(2));

        ResultadoOperacao resultadoOperacao = usuario.realizarEmprestimo(livro);

        console.print(resultadoOperacao.getMensagem());

        return true;
    }
}
