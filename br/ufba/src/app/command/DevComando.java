package br.ufba.src.app.command;

import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;
import br.ufba.src.services.ResultadoOperacao;
import br.ufba.src.app.Console;
import br.ufba.src.model.Livro;

public class DevComando implements Comando {

    private Console console;

    public DevComando(Console console) {
        this.console = console;
    }

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(2));

        ResultadoOperacao resultadoOperacao = usuario.realizarDevolucao(livro);

        console.print(resultadoOperacao.getMensagem());

        return true;

    }
}
