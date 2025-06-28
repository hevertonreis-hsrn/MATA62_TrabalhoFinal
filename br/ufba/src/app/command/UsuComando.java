package br.ufba.src.app.command;

import br.ufba.src.app.Console;
import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;

public class UsuComando implements Comando {

    private Console console;

    public UsuComando(Console console) {
        this.console = console;
    }

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        String dados = usuario.consultarInformacoes();

        console.print(dados);

        return true;

    }
}
