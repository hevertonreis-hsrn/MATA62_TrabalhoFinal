package br.ufba.src.app.command;

import br.ufba.src.app.Console;
import br.ufba.src.constantes.Mensagem;
import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;

public class NtfComando implements Comando {

    private Console console;

    public NtfComando(Console console) {
        this.console = console;
    }

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        int numeroNotificacoes = usuario.consultarNotificacoes();

        console.print(numeroNotificacoes + Mensagem.totalNotificacoes);

        return true;
    }
}
