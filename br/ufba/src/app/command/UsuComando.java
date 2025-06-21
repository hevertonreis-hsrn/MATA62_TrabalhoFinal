package br.ufba.src.app.command;

import br.ufba.src.model.Usuario;
import br.ufba.src.repository.Repositorio;

public class UsuComando implements Comando {
    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        usuario.consultarInformacoes();

        return true;

    }
}
