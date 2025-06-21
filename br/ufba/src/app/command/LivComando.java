package br.ufba.src.app.command;

import br.ufba.src.model.Livro;
import br.ufba.src.repository.Repositorio;

public class LivComando implements Comando {

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(1));

        livro.consultarInformacoes();

        return true;
    }
}
