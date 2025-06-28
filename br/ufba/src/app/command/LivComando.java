package br.ufba.src.app.command;

import br.ufba.src.app.Console;
import br.ufba.src.model.Livro;
import br.ufba.src.repository.Repositorio;

public class LivComando implements Comando {

    private Console console;

    public LivComando(Console console) {
        this.console = console;
    }

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(1));

        String dados = livro.consultarInformacoes();

        console.print(dados);

        return true;
    }
}
