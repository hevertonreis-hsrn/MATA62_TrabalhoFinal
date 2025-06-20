package MATA62_TrabalhoFinal.br.ufba.src.model;
public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public void realizarEmprestimo(Livro livro) {
    }

    @Override
    public void realizarDevolucao(Livro livro) {

    }


    public void realizarReserva(Livro livro) {

    }

    @Override
    public void observarLivro(Livro livro) {

    }

}
