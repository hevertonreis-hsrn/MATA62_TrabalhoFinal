package MATA62_TrabalhoFinal.br.ufba.src.app;

import MATA62_TrabalhoFinal.br.ufba.src.model.Usuario;
import MATA62_TrabalhoFinal.br.ufba.src.repository.Repositorio;
import MATA62_TrabalhoFinal.br.ufba.src.model.Livro;

public class DevComando implements Comando {
    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(2));

        usuario.realizarDevolucao(livro);

        return true;

    }
}
