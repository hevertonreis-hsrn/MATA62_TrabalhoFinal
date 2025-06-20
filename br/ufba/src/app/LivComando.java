package MATA62_TrabalhoFinal.br.ufba.src.app;

import MATA62_TrabalhoFinal.br.ufba.src.model.Livro;
import MATA62_TrabalhoFinal.br.ufba.src.repository.Repositorio;

public class LivComando implements Comando {

    @Override
    public boolean executar(Parametros parametros) {
        Repositorio repositorio = Repositorio.getInstancia();

        Livro livro = repositorio.buscarLivroPorCodigo(parametros.getP(1));

        livro.consultarInformacoes();

        return true;
    }
}
