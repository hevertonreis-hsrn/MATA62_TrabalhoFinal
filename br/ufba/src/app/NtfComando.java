package MATA62_TrabalhoFinal.br.ufba.src.app;

import MATA62_TrabalhoFinal.br.ufba.src.model.Usuario;
import MATA62_TrabalhoFinal.br.ufba.src.repository.Repositorio;

public class NtfComando implements Comando {

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(parametros.getP(1));

        usuario.consultarNotificacoes();

        return true;
    }
}
